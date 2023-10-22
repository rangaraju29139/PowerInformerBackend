package com.managefarming.powerinformerbackend.services;

import com.managefarming.powerinformerbackend.DTO.device.DeviceDto;
import com.managefarming.powerinformerbackend.DTO.device.mapper.DeviceDtoMapper;
import com.managefarming.powerinformerbackend.DTO.deviceEvent.DeviceEventDto;
import com.managefarming.powerinformerbackend.DTO.deviceEvent.mappers.DeviceEventDtoMapper;
import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.entities.DeviceEvent;
import com.managefarming.powerinformerbackend.entities.Farm;
import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.exceptions.DeviceEventNotFoundException;
import com.managefarming.powerinformerbackend.exceptions.DevicesNotFoundException;
import com.managefarming.powerinformerbackend.exceptions.FarmerNotFoundException;
import com.managefarming.powerinformerbackend.repositories.DeviceEventRepository;
import com.managefarming.powerinformerbackend.repositories.DeviceRepository;
import com.managefarming.powerinformerbackend.repositories.FarmRepository;
import com.managefarming.powerinformerbackend.repositories.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private DeviceEventRepository deviceEventRepository;

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


    public List<DeviceDto> getAllDevicesByFarmerId(Long farmerId) {

        Optional<Farmer> farmer = farmerRepository.findById(farmerId);
        if(farmer.isEmpty()){
            throw  new FarmerNotFoundException();
        }
        List<Device> devices = deviceRepository.findByFarmer(farmer.get());
        if(devices==null){
            throw  new DevicesNotFoundException("no devices found for this farmer");
        }

        return devices.stream().map(device -> DeviceDtoMapper.maptoDeviceDto(device)).collect(Collectors.toList());




    }

    public List<DeviceEventDto> getDeviceEventsByDeviceId(long deviceId) {
        Device device = deviceRepository.findById(deviceId).get();
        if(device==null){
            throw new DevicesNotFoundException("Device not found with id " + deviceId);
        }
        List<DeviceEvent> deviceEvents = deviceEventRepository.findByDeviceOrderByEventTime(device);

        if(deviceEvents == null){
            throw new DeviceEventNotFoundException("Device event not found with device id " + deviceId);
        }

        return deviceEvents.stream().map(deviceEvent -> {
          return   DeviceEventDtoMapper.mapToDeviceEventDto(deviceEvent);
        }).collect(Collectors.toList());

    }
}
