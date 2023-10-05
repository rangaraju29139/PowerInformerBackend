package com.managefarming.powerinformerbackend.exceptions;

public class DeviceNotCreatedException extends Exception {

    public DeviceNotCreatedException(String message){
        super(message);
        System.out.println("DeviceNotCreatedException");
    }
}
