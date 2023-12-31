package com.managefarming.powerinformerbackend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
@Setter
@AllArgsConstructor
public class FarmNotFoundException extends RuntimeException{
 public FarmNotFoundException(String message){
  super(message);
  System.out.println(message);
 }

}
