package com.managefarming.powerinformerbackend.services;


import com.managefarming.powerinformerbackend.DTO.farm.FarmResponseDto;
import com.managefarming.powerinformerbackend.DTO.farm.mappers.FarmResponseDtoMapper;
import com.managefarming.powerinformerbackend.DTO.farmer.FarmerResponseDto;
import com.managefarming.powerinformerbackend.DTO.farmer.mappers.FarmerResponseDtoMapper;
import com.managefarming.powerinformerbackend.entities.Farm;
import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.repositories.FarmRepository;
import com.managefarming.powerinformerbackend.repositories.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private FarmRepository farmRepository;



    public FarmerResponseDto createFarmer(Farmer farmer) {
        Farmer result = farmerRepository.save(farmer);

        if(result == null){
            return null;
        }
        return FarmerResponseDtoMapper.maptoResponseDto(result);

    }

    public FarmerResponseDto getFarmerByFarmerId(Long farmerId) {
        Farmer farmer = farmerRepository.findById(farmerId).stream().findFirst().get();
        if(farmer == null){
            return null;
        }
        return FarmerResponseDtoMapper.maptoResponseDto(farmer);
    }

//    public List<FarmResponseDto> getFarmersByFarmerId(Long farmerId) {
//        List<Farm> result = farmRepository.findByFarmerId(farmerId).stream().toList();
//        if(result ==null){
//            return null;
//        }
//        List<FarmResponseDto> farmResponseDtoList = result.stream().map(farm -> FarmResponseDtoMapper.mapToFarmResponseDto(farm)).toList();
//        return farmResponseDtoList;
//    }
}
