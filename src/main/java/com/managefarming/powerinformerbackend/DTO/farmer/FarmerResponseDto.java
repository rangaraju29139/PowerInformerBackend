package com.managefarming.powerinformerbackend.DTO.farmer;


import lombok.Builder;
import lombok.Data;


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
    private String password;
}
