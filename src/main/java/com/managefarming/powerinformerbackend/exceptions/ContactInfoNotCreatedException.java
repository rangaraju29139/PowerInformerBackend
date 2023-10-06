package com.managefarming.powerinformerbackend.exceptions;

public class ContactInfoNotCreatedException extends Exception {
    public ContactInfoNotCreatedException(String message) {
        super(message);
        System.out.println(message);
    }
}
