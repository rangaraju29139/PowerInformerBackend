package com.managefarming.powerinformerbackend.DTO.farm;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FarmResponseDto {
    private long farmId;
    private String farmName;
    private String locationDescription;

}
