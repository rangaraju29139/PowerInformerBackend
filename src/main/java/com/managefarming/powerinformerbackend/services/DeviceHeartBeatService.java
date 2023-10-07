package com.managefarming.powerinformerbackend.services;

import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.entities.DeviceEvent;
import com.managefarming.powerinformerbackend.enums.DeviceEventType;
import com.managefarming.powerinformerbackend.enums.PowerStatus;
import com.managefarming.powerinformerbackend.exceptions.DeviceEventNotCreatedException;
import com.managefarming.powerinformerbackend.repositories.DeviceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;


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


    //run the checkEventStatus every 5 seconds

    @Scheduled(fixedRate = 15000,initialDelay = 30000)
    public void checkAllDeviceEventStatus(){
        List<Device> allDevices = deviceRepository.findAll();

        Consumer<Device> consumer = (device)-> {
          Optional<DeviceEvent> event = checkAndUpdateDeviceEvent(device);
          if(event!= null){

              log.info("Event Occured on Device Id "+device.getDeviceId() + " Device name: "+device.getDeviceName()+ " Event: "+ event.get().getEventType()+" At time: "+ event.get().getEventTime());
              System.out.println("Event Occured on Device Id "+device.getDeviceId() + " Device name: "+device.getDeviceName()+ " Event: "+ event.get().getEventType()+" At time: "+ event.get().getEventTime());
          }
        };
        allDevices.forEach(consumer);

    }





    public Optional<DeviceEvent> handleDeviceHeartBeat(Long deviceId, String deviceAuthCode) throws DeviceEventNotCreatedException {
        Device device = deviceRepository.findById(deviceId).get();

        if(device == null || !(device.getDeviceAuthCode().equalsIgnoreCase(deviceAuthCode))){
            return null;
        }
        Optional<DeviceEvent> deviceEvent = checkAndUpdateDeviceEvent(device);

        device.setLastHeartBeatSignal(ZonedDateTime.now());
        deviceRepository.save(device);

        return deviceEvent;
    }

    public int timeDifference(ZonedDateTime now, ZonedDateTime lastHearBeatSignal){
        return Math.abs((int)(now.toEpochSecond() - lastHearBeatSignal.toEpochSecond())/60);
    }

    public Optional<DeviceEvent> checkAndUpdateDeviceEvent(Device device)  {

        Optional<DeviceEvent> event = null;

        ZonedDateTime lastHearBeat = device.getLastHeartBeatSignal();
        ZonedDateTime now  = ZonedDateTime.now();
        if(timeDifference(now,lastHearBeat) > device.getMinutesDelayToNotify() ){
            if(device.getCurrentDeviceStatus() == PowerStatus.AVAILABLE){
                device.setCurrentDeviceStatus(PowerStatus.NOT_AVAILABLE);

              event = Optional.ofNullable(deviceEventService.udpateEvent(device, DeviceEventType.ON_TO_OFF));
                twilioService.sendInformation(device,DeviceEventType.ON_TO_OFF);
            }else{
                device.setCurrentDeviceStatus(PowerStatus.AVAILABLE);

             event = Optional.ofNullable(deviceEventService.udpateEvent(device, DeviceEventType.OFF_TO_ON));
                twilioService.sendInformation(device,DeviceEventType.OFF_TO_ON);
            }

        }
        return event;
    }
}
