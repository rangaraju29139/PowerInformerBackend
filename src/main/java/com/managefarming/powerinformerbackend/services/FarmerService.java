package com.managefarming.powerinformerbackend.services;


import com.managefarming.powerinformerbackend.DTO.farmer.FarmerResponseDto;
import com.managefarming.powerinformerbackend.DTO.farmer.mappers.FarmerResponseDtoMapper;
import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.repositories.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;
    public FarmerResponseDto createFarmer(Farmer farmer) {
        Farmer result = farmerRepository.save(farmer);

        if(result == null){
            return null;
        }
        return FarmerResponseDtoMapper.maptoResponseDto(result);

    }
}
