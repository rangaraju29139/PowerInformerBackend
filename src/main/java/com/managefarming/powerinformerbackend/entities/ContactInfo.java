package com.managefarming.powerinformerbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContactInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //should refer the device id in device table
    private Long DeviceId;


    // will be the order in which the contact get notified.
    private int priority;
    private String contactName;
    private String countryCode;
    private String phoneNumber;

}
