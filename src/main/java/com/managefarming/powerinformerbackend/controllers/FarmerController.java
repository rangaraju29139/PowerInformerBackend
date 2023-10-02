package com.managefarming.powerinformerbackend.controllers;

import com.managefarming.powerinformerbackend.entities.Farm;
import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.services.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FarmerController {

    @Autowired
    private FarmerService farmerService;




    @RequestMapping(value = "/farmers",method = RequestMethod.POST)
    public ResponseEntity addFarmer(@RequestBody Farmer farmer){

        Long farmerId = farmerService.addFarmer(farmer);
        return  ResponseEntity.ok("Farmer Created at FarmerId: "+farmerId);
    }



}
