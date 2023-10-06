package com.managefarming.powerinformerbackend.services;

import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.entities.DeviceEvent;
import com.managefarming.powerinformerbackend.enums.DeviceEventType;
import com.managefarming.powerinformerbackend.enums.PowerStatus;
import com.managefarming.powerinformerbackend.exceptions.DeviceEventNotCreatedException;
import com.managefarming.powerinformerbackend.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;


@Service
public class DeviceHeartBeatService {



    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private TwilioService twilioService;

    @Autowired
    private DeviceEventService deviceEventService;





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

    public Optional<DeviceEvent> checkAndUpdateDeviceEvent(Device device) throws DeviceEventNotCreatedException {

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
