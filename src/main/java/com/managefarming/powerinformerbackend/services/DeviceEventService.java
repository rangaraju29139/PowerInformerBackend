package com.managefarming.powerinformerbackend.services;

import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.entities.DeviceEvent;
import com.managefarming.powerinformerbackend.enums.DeviceEventType;
import com.managefarming.powerinformerbackend.exceptions.DeviceEventNotCreatedException;
import com.managefarming.powerinformerbackend.repositories.DeviceEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;


@Service
public class DeviceEventService {

    @Autowired
    private DeviceEventRepository deviceEventRepository;
    public DeviceEvent udpateEvent(Device device, DeviceEventType deviceEventType)  {
        DeviceEvent event = DeviceEvent.builder()
                .eventTime(ZonedDateTime.now())
                .eventType(deviceEventType)
                .device(device)
                .build();
        DeviceEvent result = deviceEventRepository.save(event);
        if(result == null){
            throw new DeviceEventNotCreatedException("Device Event Not Created");

        }
        return result;
    }
}
