package com.managefarming.powerinformerbackend.DTO.farmer.mappers;

import com.managefarming.powerinformerbackend.DTO.farmer.FarmerRequestDto;
import com.managefarming.powerinformerbackend.entities.Farmer;

public class FarmerRequestDtoMapper {
    public static Farmer maptoFarmer(FarmerRequestDto farmerRequestDto){
        Farmer farmer  = Farmer.builder()
                .farmerId(farmerRequestDto.getFarmerId())
                .countryCode(farmerRequestDto.getCountryCode())
                .email(farmerRequestDto.getEmail())
                .firstName(farmerRequestDto.getFirstName())
                .lastName(farmerRequestDto.getLastName())
                .phoneNumber(farmerRequestDto.getPhoneNumber())
                .balance(farmerRequestDto.getBalance())
                .password(farmerRequestDto.getPassword())
                .build();
        return farmer;

    }
}
