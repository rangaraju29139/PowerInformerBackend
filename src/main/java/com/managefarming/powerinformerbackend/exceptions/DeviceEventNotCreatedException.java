package com.managefarming.powerinformerbackend.exceptions;

public class DeviceEventNotCreatedException extends RuntimeException {
    public DeviceEventNotCreatedException(String deviceEventNotCreated) {
        super(deviceEventNotCreated);
        System.out.println(deviceEventNotCreated);
    }
}
