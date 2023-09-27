package com.managefarming.powerinformerbackend.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class User {


    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private long userId;

    private String firstName;
    private String lastName;
    private String PhoneNumber;
    private String countryCode;


}
