package com.managefarming.powerinformerbackend.controllers;


import com.managefarming.powerinformerbackend.DTO.farmer.FarmerRequestDto;
import com.managefarming.powerinformerbackend.DTO.farmer.FarmerResponseDto;
import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.services.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class FarmerController {

    @Autowired
    private FarmerService farmerService;


    @RequestMapping(value = "/farmers",method = RequestMethod.POST)
    public ResponseEntity<FarmerResponseDto> createFarmer( @RequestBody Farmer farmer){
        FarmerResponseDto result = farmerService.createFarmer(farmer);

        if(result == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getFarmerId()).toUri();
        return ResponseEntity.created(location).build();
    }






}
