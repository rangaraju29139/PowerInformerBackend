package com.managefarming.powerinformerbackend.controllers;


import com.managefarming.powerinformerbackend.entities.Farm;
import com.managefarming.powerinformerbackend.services.FarmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FarmController {

    @Autowired
    private FarmService farmService;

    @RequestMapping(value ="/farms",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity createFarm(@RequestBody Farm farm){
        Farm result = farmService.addFarm(farm);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        if(result == null){
            return new ResponseEntity<>(httpHeaders,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Farm Created with Id "+result.getFarmId(),httpHeaders,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/farmer/{farmerId}/farms",method=RequestMethod.GET)
    public ResponseEntity getAllFarms(@PathVariable Long farmerId){
        List<Farm> farmList = farmService.findAllFarmsByFarmerId(farmerId);
        if(farmList==null){
            return ResponseEntity.notFound().header("Content-Type", "application/json").build();
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(farmList,httpHeaders,HttpStatus.OK);
    }
}
