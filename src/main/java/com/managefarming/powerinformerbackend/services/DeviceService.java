package com.managefarming.powerinformerbackend.services;

import com.managefarming.powerinformerbackend.DTO.device.DeviceDto;
import com.managefarming.powerinformerbackend.DTO.device.mapper.DeviceDtoMapper;
import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public DeviceDto createDevice(Long farmId, Device device){
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
