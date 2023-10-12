package com.managefarming.powerinformerbackend.exceptions;

public class DevicesNotFoundException extends RuntimeException {

    public DevicesNotFoundException(String message){
        super(message);
        System.out.println(message);


    }
}
