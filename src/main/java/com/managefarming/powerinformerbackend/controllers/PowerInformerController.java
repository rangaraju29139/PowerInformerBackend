package com.managefarming.powerinformerbackend.controllers;


import org.springframework.web.bind.annotation.*;

@RestController

public class PowerInformerController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getHomePage(){
        return "hello there";
    }


}
