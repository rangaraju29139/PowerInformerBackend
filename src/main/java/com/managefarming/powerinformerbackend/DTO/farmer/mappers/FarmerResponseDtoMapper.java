package com.managefarming.powerinformerbackend.DTO.farmer.mappers;

import com.managefarming.powerinformerbackend.DTO.farmer.FarmerResponseDto;
import com.managefarming.powerinformerbackend.entities.Farmer;

public class FarmerResponseDtoMapper {
    public static FarmerResponseDto maptoResponseDto(Farmer farmer){
        FarmerResponseDto farmerResponseDto = FarmerResponseDto.builder()
                .farmerId(farmer.getFarmerId())
                .countryCode(farmer.getCountryCode())
                .email(farmer.getEmail())
                .firstName(farmer.getFirstName())
                .lastName(farmer.getLastName())
                .phoneNumber(farmer.getPhoneNumber())
                .balance(farmer.getBalance())
                .password(farmer.getPassword())
                .build();
        return farmerResponseDto;

    }
}
