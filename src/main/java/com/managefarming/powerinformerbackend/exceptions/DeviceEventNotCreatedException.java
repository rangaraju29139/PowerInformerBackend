package com.managefarming.powerinformerbackend.exceptions;

public class DeviceEventNotCreatedException extends Exception {
    public DeviceEventNotCreatedException(String deviceEventNotCreated) {
        super(deviceEventNotCreated);
        System.out.println(deviceEventNotCreated);
    }
}
