package com.managefarming.powerinformerbackend.controllers;


import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.services.FarmerService;
import com.managefarming.powerinformerbackend.services.HandleHeartBeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerInformerController {

    @Autowired
    private HandleHeartBeatService handleHeartBeatService;

    @Autowired
    private FarmerService farmerService;


    @RequestMapping("/device-heart-beat/{deviceId}/{authToken}")
    public void handleDeviceHeartbeat(@PathVariable long deviceId, @PathVariable long authToken){
        System.out.println("deviceId: " + deviceId);
        System.out.println("AuthToken: " + authToken);
    }

    @RequestMapping("/farmers/{farmerId}")
    public Farmer getFarmersById(@PathVariable Long farmerId){
        return farmerService.getFarmerByFarmerId(farmerId);
    }
}
