package com.managefarming.powerinformerbackend.services;


import com.managefarming.powerinformerbackend.DTO.device.DeviceDto;
import com.managefarming.powerinformerbackend.DTO.device.mapper.DeviceDtoMapper;
import com.managefarming.powerinformerbackend.DTO.farm.FarmResponseDto;
import com.managefarming.powerinformerbackend.DTO.farm.mappers.FarmResponseDtoMapper;
import com.managefarming.powerinformerbackend.DTO.farmer.mappers.FarmerResponseDtoMapper;
import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.entities.Farm;
import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.repositories.DeviceRepository;
import com.managefarming.powerinformerbackend.repositories.FarmRepository;
import com.managefarming.powerinformerbackend.repositories.FarmerRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmService {

    @Autowired
    private FarmerRepository farmerRepository;
    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private DeviceRepository deviceRepository;




    public FarmResponseDto createFarm(Long farmerId,Farm farm){
        Farmer farmer = farmerRepository.findById(farmerId).get();
        farm.setFarmer(farmer);
        farmRepository.save(farm);
        return FarmResponseDtoMapper.mapToFarmResponseDto(farm);

    }


    public FarmResponseDto getFarmByFarmId(Long farmId) {

        Farm farm = farmRepository.findById(farmId).stream().findFirst().get();
        if(farm == null){
            return null;

        }
        return FarmResponseDtoMapper.mapToFarmResponseDto(farm);
    }


    public List<DeviceDto> getDevicesByFarmId(Long farmId) {
        Farm farm = farmRepository.findById(farmId).get();
        List<DeviceDto> deviceDtos = deviceRepository.findByFarm(farm).stream().map(device -> DeviceDtoMapper.maptoDeviceDto(device)).toList();
        if(deviceDtos == null){
            return null;
        }
        return deviceDtos;
    }
}
