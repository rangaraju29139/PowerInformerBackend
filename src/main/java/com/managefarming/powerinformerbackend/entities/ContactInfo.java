package com.managefarming.powerinformerbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ContactInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //should refer the device id in device table
    @ManyToOne
    @JoinColumn(name ="device_id",referencedColumnName = "device_id",nullable = false)
    private Device device;


    // will be the order in which the contact get notified.
    private int priority;
    private String contactName;
    private String countryCode;
    private String phoneNumber;

}
