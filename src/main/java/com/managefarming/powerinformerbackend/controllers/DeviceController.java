package com.managefarming.powerinformerbackend.controllers;


import com.managefarming.powerinformerbackend.DTO.device.DeviceDto;
import com.managefarming.powerinformerbackend.DTO.device.DeviceRequestDto;
import com.managefarming.powerinformerbackend.DTO.device.mapper.DeviceRequestDtoMapper;
import com.managefarming.powerinformerbackend.DTO.deviceEvent.DeviceEventDto;
import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.exceptions.DeviceNotCreatedException;
import com.managefarming.powerinformerbackend.services.DeviceService;
import com.managefarming.powerinformerbackend.services.FarmService;
import com.managefarming.powerinformerbackend.services.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private FarmService farmService;

    @Autowired
    private FarmerService farmerService;


    @RequestMapping(value = "/farms/{farmId}/devices",method = RequestMethod.POST)
    public ResponseEntity  createDevice(@PathVariable Long farmId, @RequestBody DeviceRequestDto deviceRequestDto) throws DeviceNotCreatedException {

        Device device = DeviceRequestDtoMapper.maptoDevice(deviceRequestDto);
        DeviceDto deviceDto = deviceService.createDevice(farmId,device);
        if(deviceDto == null){
            throw new DeviceNotCreatedException("Device Not Created");
        }


        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{deviceDto.getDeviceId}")
                .buildAndExpand(deviceDto.getDeviceId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @RequestMapping(value ="/devices/{deviceId}",method = RequestMethod.GET)
    public ResponseEntity<DeviceDto> getDeviceById(@PathVariable Long deviceId){
        DeviceDto deviceDto = deviceService.getDeviceById(deviceId);

        if(deviceDto==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deviceDto);
    }

    @RequestMapping(value = "/farms/{farmId}/devices/{deviceId}",method = RequestMethod.GET)
    public ResponseEntity<DeviceDto> getDeviceByDeviceId(@PathVariable Long farmId, @PathVariable Long deviceId){
        return getDeviceById(deviceId);
    }

    @RequestMapping(value ="/farmers/{farmerId}/devices", method = RequestMethod.GET)
    public ResponseEntity<List<DeviceDto>> getAllDevicesByFarmerId(@PathVariable Long farmerId){


        List<DeviceDto> deviceDtos = deviceService.getAllDevicesByFarmerId(farmerId);

        if(deviceDtos==null || deviceDtos.size() ==0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deviceDtos);


    }

    @RequestMapping(value ="/devices/{deviceId}/device-events",method = RequestMethod.GET)
    public ResponseEntity<List<DeviceEventDto>> getDeviceEventsByDeviceId(@PathVariable long deviceId){
        List<DeviceEventDto> deviceEvents = deviceService.getDeviceEventsByDeviceId(deviceId);
        if(deviceEvents==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deviceEvents);

    }



}
