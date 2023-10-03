package com.managefarming.powerinformerbackend.DTO.farmer;


import com.managefarming.powerinformerbackend.entities.Farm;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class FarmerResponseDto {

    private Long farmerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String countryCode;
    private String email;
    private Double balance;
}
