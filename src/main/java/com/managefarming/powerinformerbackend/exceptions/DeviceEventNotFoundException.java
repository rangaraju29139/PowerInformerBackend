package com.managefarming.powerinformerbackend.exceptions;

public class DeviceEventNotFoundException extends RuntimeException {
    public DeviceEventNotFoundException(String s) {
        super(s);
        System.out.println(s);
    }
}
