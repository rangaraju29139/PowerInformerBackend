package com.managefarming.powerinformerbackend.exceptions;

public class ContactInfoNotFoundException extends Exception{

    public ContactInfoNotFoundException(String message){
        super(message);
        System.out.println(message);
    }
}
