package com.managefarming.powerinformerbackend.DTO.farm.mappers;


import com.managefarming.powerinformerbackend.DTO.farm.FarmResponseDto;
import com.managefarming.powerinformerbackend.entities.Farm;
import lombok.*;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FarmResponseDtoMapper {
    public static FarmResponseDto mapToFarmResponseDto(Farm farm){
        FarmResponseDto result = FarmResponseDto.builder().farmId(farm.getFarmId())
                .farmName(farm.getFarmName())
                .locationDescription(farm.getLocationDescription()).build();

        return result;
    }
}
