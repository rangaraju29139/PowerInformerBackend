package com.managefarming.powerinformerbackend.exceptions;

public class DeviceNotCreatedException extends RuntimeException {

    public DeviceNotCreatedException(String message){
        super(message);
        System.out.println("DeviceNotCreatedException");
    }
}
