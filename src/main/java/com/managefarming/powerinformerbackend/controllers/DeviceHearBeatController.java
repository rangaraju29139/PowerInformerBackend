package com.managefarming.powerinformerbackend.controllers;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.managefarming.powerinformerbackend.DTO.deviceEvent.mappers.DeviceEventDtoMapper;
import com.managefarming.powerinformerbackend.entities.DeviceEvent;
import com.managefarming.powerinformerbackend.exceptions.DeviceEventNotCreatedException;
import com.managefarming.powerinformerbackend.services.DeviceHeartBeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DeviceHearBeatController {

    @Autowired
    private DeviceHeartBeatService deviceHeartBeatService;

    @JsonIgnore
    @RequestMapping(value = "/devices/{deviceId}/heart-beat", method = RequestMethod.GET)
    public ResponseEntity handleDeviceHeartBeat(@PathVariable Long deviceId, @RequestParam String deviceAuthCode) throws DeviceEventNotCreatedException {
        Optional<DeviceEvent> deviceEvent = deviceHeartBeatService.handleDeviceHeartBeat(deviceId,deviceAuthCode);
        if(deviceEvent == null){
            return ResponseEntity.ok("""
                    {
                    "status": "No new Event Found"
                    }
                    """);
        }

        return ResponseEntity.ok(DeviceEventDtoMapper.mapToDeviceEventDto(deviceEvent.get()));
    }
}
