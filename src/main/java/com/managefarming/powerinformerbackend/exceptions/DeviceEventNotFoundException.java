package com.managefarming.powerinformerbackend.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DeviceEventNotFoundException extends RuntimeException {
    public DeviceEventNotFoundException(String s) {
        super(s);
        System.out.println(s);
    }
}
