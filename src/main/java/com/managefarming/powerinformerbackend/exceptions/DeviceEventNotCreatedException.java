package com.managefarming.powerinformerbackend.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DeviceEventNotCreatedException extends RuntimeException {
    public DeviceEventNotCreatedException(String deviceEventNotCreated) {
        super(deviceEventNotCreated);
        System.out.println(deviceEventNotCreated);
    }
}
