package com.managefarming.powerinformerbackend.DTO.farmer;

import com.managefarming.powerinformerbackend.entities.Farm;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
public class FarmerRequestDto {

    private Long farmerId;


    private String firstName;

    private String lastName;


    private String phoneNumber;


    private String countryCode;


    private String email;


    private String password;

    private Double balance;
}
