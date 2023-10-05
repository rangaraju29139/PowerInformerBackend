package com.managefarming.powerinformerbackend.controllers;


import com.managefarming.powerinformerbackend.DTO.device.DeviceDto;
import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.exceptions.DeviceNotCreatedException;
import com.managefarming.powerinformerbackend.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    @RequestMapping(value = "/farms/{farmId}/devices",method = RequestMethod.POST)
    public ResponseEntity  createDevice(@PathVariable Long farmId, @RequestBody Device device) throws DeviceNotCreatedException {
        DeviceDto deviceDto = deviceService.createDevice(farmId,device);
        if(deviceDto == null){
            throw new DeviceNotCreatedException("Device Not Created");
        }


        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{deviceDto.getDeviceId}")
                .buildAndExpand(deviceDto.getDeviceId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @RequestMapping(value = "/devices/{deviceId}",method = RequestMethod.GET)
    public ResponseEntity<DeviceDto> getDeviceById(@PathVariable Long deviceId){
        DeviceDto deviceDto = deviceService.getDeviceById(deviceId);

        if(deviceDto==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deviceDto);
    }

}
