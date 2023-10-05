package com.managefarming.powerinformerbackend.services;

import com.managefarming.powerinformerbackend.DTO.device.DeviceDto;
import com.managefarming.powerinformerbackend.DTO.device.mapper.DeviceDtoMapper;
import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.entities.Farm;
import com.managefarming.powerinformerbackend.repositories.DeviceRepository;
import com.managefarming.powerinformerbackend.repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private FarmRepository farmRepository;

    public DeviceDto createDevice(Long farmId, Device device){
        Farm farm = farmRepository.findById(farmId).get();
        device.setFarm(farm);
        Device result = deviceRepository.save(device);
        if(result == null){
            return null;
        }
        return DeviceDtoMapper.maptoDeviceDto(device);
    }

    public DeviceDto getDeviceById(Long deviceId) {
        Device device = deviceRepository.findById(deviceId).orElse(null);
        return DeviceDtoMapper.maptoDeviceDto(device);
    }
}
