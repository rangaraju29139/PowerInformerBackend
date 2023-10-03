package com.managefarming.powerinformerbackend.controllers;


import com.managefarming.powerinformerbackend.DTO.farm.FarmResponseDto;
import com.managefarming.powerinformerbackend.entities.Farm;
import com.managefarming.powerinformerbackend.exceptions.FarmNotFoundException;
import com.managefarming.powerinformerbackend.services.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class FarmController {

    @Autowired
    private FarmService farmService;

    @RequestMapping(value = "/farmers/{farmerId}/farms")
    public ResponseEntity<FarmResponseDto> createFarm(@PathVariable Long farmerId, @RequestBody Farm farm){

        FarmResponseDto result = farmService.createFarm(farmerId,farm);
        if(result == null){
            throw new FarmNotFoundException("Farm with id " +farm.getFarmId() + " not found");
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{farmId}")
                .buildAndExpand(result.getFarmId()).toUri();
        return ResponseEntity.created(location).build();




    }
}
