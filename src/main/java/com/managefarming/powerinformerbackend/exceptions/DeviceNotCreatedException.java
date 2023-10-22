package com.managefarming.powerinformerbackend.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DeviceNotCreatedException extends RuntimeException {

    public DeviceNotCreatedException(String message){
        super(message);
        System.out.println("DeviceNotCreatedException");
    }
}
