package com.managefarming.powerinformerbackend.exceptions;

public class ContactInfoNotFoundException extends RuntimeException{

    public ContactInfoNotFoundException(String message){
        super(message);
        System.out.println(message);
    }
}
