package com.managefarming.powerinformerbackend.services;

import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.entities.DeviceEvent;
import com.managefarming.powerinformerbackend.enums.DeviceEventType;
import com.managefarming.powerinformerbackend.enums.HeartBeatCheckType;
import com.managefarming.powerinformerbackend.enums.PowerStatus;
import com.managefarming.powerinformerbackend.exceptions.DeviceEventNotCreatedException;
import com.managefarming.powerinformerbackend.repositories.DeviceEventRepository;
import com.managefarming.powerinformerbackend.repositories.DeviceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;


@Service
@Log4j2
@EnableScheduling
public class DeviceHeartBeatService {



    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private TwilioService twilioService;

    @Autowired
    private DeviceEventService deviceEventService;

    @Autowired
    private DeviceEventRepository deviceEventRepository;


    //run the checkEventStatus every 5 seconds

    @Scheduled(fixedRate = 15000,initialDelay = 30000)
    public void checkAllDeviceEventStatus(){
        List<Device> allDevices = deviceRepository.findAll();

        Consumer<Device> consumer = (device)-> {
          Optional<DeviceEvent> event = checkAndUpdateDeviceEvent(device, HeartBeatCheckType.SCHEDULED_CHECK);
          if(event!= null){

              log.info("Event Occured on Device Id "+device.getDeviceId() + " Device name: "+device.getDeviceName()+ " Event: "+ event.get().getEventType()+" At time: "+ event.get().getEventTime());
              System.out.println("Event Occured on Device Id "+device.getDeviceId() + " Device name: "+device.getDeviceName()+ " Event: "+ event.get().getEventType()+" At time: "+ event.get().getEventTime());
          }
        };
        allDevices.forEach(consumer);

    }

    @Scheduled(fixedRate = 30000,initialDelay = 20000)
    public void deleteOldEventDataFromDeviceEvent(){
        List<DeviceEvent> deviceEvents = deviceEventRepository.findAll();

        Predicate<DeviceEvent> predicate  = (deviceEvent -> {
           int numDaysLogKeeping = deviceRepository.findById(deviceEvent.getDevice().getDeviceId()).get().getNumDaysLogKeeping();

         if(timeDifference(LocalDateTime.now(),deviceEvent.getEventTime()) > numDaysLogKeeping*1440){
             return true;
         }
         return false;
        });

        Consumer<DeviceEvent> consumer = (deviceEvent -> {
             deviceEventRepository.deleteById(deviceEvent.getId());
        });
        if(deviceEvents.size() > 0){
           deviceEvents.stream().filter(predicate).forEach(consumer);
        }
    }





    public synchronized Optional<DeviceEvent> handleDeviceHeartBeat(Long deviceId, String deviceAuthCode) throws DeviceEventNotCreatedException {
        Device device = deviceRepository.findById(deviceId).get();

        if(device == null || !(device.getDeviceAuthCode().equalsIgnoreCase(deviceAuthCode))){
            return null;
        }
        Optional<DeviceEvent> deviceEvent = checkAndUpdateDeviceEvent(device,HeartBeatCheckType.HEART_BEAT);


        return deviceEvent;
    }

    public int timeDifference(LocalDateTime now, LocalDateTime lastHearBeatSignal){
//        System.out.println(" now : "+ now.toString() + " lastHearBeatSignal : "+ lastHearBeatSignal.toString());
        int timeDifference =  (int)ChronoUnit.MINUTES.between(now,lastHearBeatSignal);
//        System.out.println("***** time difference : "+timeDifference);
        return Math.abs(timeDifference);
    }

    public   Optional<DeviceEvent>  checkAndUpdateDeviceEvent(Device device , HeartBeatCheckType checkType)  {

        synchronized (device){
            Optional<DeviceEvent> event = null;
            PowerStatus currentPowerStatus = device.getCurrentDeviceStatus();


            LocalDateTime lastHearBeat = device.getLastHeartBeatSignal().plusHours(0);
            LocalDateTime now = LocalDateTime.now().plusHours(0);
            int timeDiff = timeDifference(now,lastHearBeat);
            if( timeDiff> device.getMinutesDelayToNotify() ){
                if(currentPowerStatus == PowerStatus.AVAILABLE){
                    System.out.println("timeDiff "+timeDiff+" currentPowerStatus "+currentPowerStatus);
                    device.setCurrentDeviceStatus(PowerStatus.NOT_AVAILABLE);
                    event = Optional.ofNullable(deviceEventService.udpateEvent(device, DeviceEventType.ON_TO_OFF));
                    deviceRepository.save(device);
                    twilioService.sendInformation(device,DeviceEventType.ON_TO_OFF);
                }


            }
            if(device.getCurrentDeviceStatus() == PowerStatus.NOT_AVAILABLE  && checkType==HeartBeatCheckType.HEART_BEAT){
                System.out.println("timeDiff "+timeDiff+" currentPowerStatus "+currentPowerStatus);
                device.setCurrentDeviceStatus(PowerStatus.AVAILABLE);
                deviceRepository.save(device);
                event = Optional.ofNullable(deviceEventService.udpateEvent(device, DeviceEventType.OFF_TO_ON));
                twilioService.sendInformation(device,DeviceEventType.OFF_TO_ON);
            }
            if(checkType==HeartBeatCheckType.HEART_BEAT){
                System.out.println("timeDiff "+timeDiff+" currentPowerStatus "+currentPowerStatus);
                device.setLastHeartBeatSignal(LocalDateTime.now());
                deviceRepository.save(device);
            }

            return event;

        }

    }
}
