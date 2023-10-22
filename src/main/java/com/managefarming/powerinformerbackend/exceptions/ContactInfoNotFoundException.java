package com.managefarming.powerinformerbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactInfoNotFoundException extends RuntimeException{

    public ContactInfoNotFoundException(String message){
        super(message);
        System.out.println(message);
    }
}
