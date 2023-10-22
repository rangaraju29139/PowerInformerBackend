package com.managefarming.powerinformerbackend.controllers;


import com.managefarming.powerinformerbackend.DTO.farm.FarmResponseDto;
import com.managefarming.powerinformerbackend.DTO.farmer.FarmerRequestDto;
import com.managefarming.powerinformerbackend.DTO.farmer.FarmerResponseDto;
import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.exceptions.FarmNotFoundException;
import com.managefarming.powerinformerbackend.exceptions.FarmerNotFoundException;
import com.managefarming.powerinformerbackend.services.FarmerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class FarmerController {

    @Autowired
    private FarmerService farmerService;


    @RequestMapping(value = "/farmers",method = RequestMethod.POST)
    public ResponseEntity<FarmerResponseDto> createFarmer(@Valid @RequestBody Farmer farmer){
        FarmerResponseDto result = farmerService.createFarmer(farmer);

        if(result == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getFarmerId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/farmers/{farmerId}", method = RequestMethod.GET)
    public ResponseEntity<FarmerResponseDto> getFarmerByFarmerId(@PathVariable Long farmerId) throws FarmerNotFoundException {
        FarmerResponseDto result = farmerService.getFarmerByFarmerId(farmerId);
        if(result == null){
            throw new FarmerNotFoundException("Farmer with id " +farmerId + " not found");
        }

        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/farmers/{farmerId}", method = RequestMethod.PUT)
    public ResponseEntity<FarmerResponseDto> updateFarmer(@PathVariable Long farmerId,@Valid  @RequestBody FarmerRequestDto farmerRequestDto){
        FarmerResponseDto farmer = farmerService.updateFarmer(farmerRequestDto);

        if(farmer == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(farmer);
    }

    @RequestMapping(value = "/farmers/{farmerId}/farms",method = RequestMethod.GET)
    public ResponseEntity<List<FarmResponseDto>> getFarmsByFarmerId(@PathVariable Long farmerId){
        List<FarmResponseDto> result = farmerService.getFarmersByFarmerId(farmerId);

        if(result==null){
            throw new FarmNotFoundException("farm with farmer id " +farmerId + " not found");
        }
        return ResponseEntity.ok(result);
    }








}
