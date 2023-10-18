package com.managefarming.powerinformerbackend.controllers;


import com.managefarming.powerinformerbackend.services.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Twiliocontroller {

    @Autowired
    private TwilioService twilioService;

    @RequestMapping(value = "/twilio/make-call",method = RequestMethod.GET)
    public ResponseEntity makeCall(){

        twilioService.makeCall();
  return ResponseEntity.ok().build();
    }
}
