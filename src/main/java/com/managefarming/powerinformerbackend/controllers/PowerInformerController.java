package com.managefarming.powerinformerbackend.controllers;


import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.services.FarmerService;
import com.managefarming.powerinformerbackend.services.HandleHeartBeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class PowerInformerController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getHomePage(){
        return "hello there";
    }


}
