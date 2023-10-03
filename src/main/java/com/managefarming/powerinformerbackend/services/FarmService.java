package com.managefarming.powerinformerbackend.services;


import com.managefarming.powerinformerbackend.DTO.farm.FarmResponseDto;
import com.managefarming.powerinformerbackend.DTO.farm.mappers.FarmResponseDtoMapper;
import com.managefarming.powerinformerbackend.DTO.farmer.mappers.FarmerResponseDtoMapper;
import com.managefarming.powerinformerbackend.entities.Farm;
import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.repositories.FarmRepository;
import com.managefarming.powerinformerbackend.repositories.FarmerRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmService {

    @Autowired
    private FarmerRepository farmerRepository;
    @Autowired
    private FarmRepository farmRepository;




    public FarmResponseDto createFarm(Long farmerId, Farm farm){
        Farmer farmer = farmerRepository.findById(farmerId).stream().findFirst().get();
        farmer.getFarms().add(farm);
        farmerRepository.save(farmer);
        return FarmResponseDtoMapper.mapToFarmResponseDto(farm);

    }


    public FarmResponseDto getFarmByFarmId(Long farmId) {

        Farm farm = (Farm) farmRepository.findById(farmId).stream().findFirst().get();
        if(farm == null){
            return null;

        }
        return FarmResponseDtoMapper.mapToFarmResponseDto(farm);

    }
}
