package com.managefarming.powerinformerbackend.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DevicesNotFoundException extends RuntimeException {

    public DevicesNotFoundException(String message){
        super(message);
        System.out.println(message);


    }
}
