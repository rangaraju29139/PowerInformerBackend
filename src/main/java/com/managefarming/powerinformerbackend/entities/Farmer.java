package com.managefarming.powerinformerbackend.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Farmer {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long farmerId;

    private String firstName;
    private String lastName;
    private String PhoneNumber;
    private String countryCode;

    public Farmer(String firstName, String lastName, String phoneNumber, String countryCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        PhoneNumber = phoneNumber;
        this.countryCode = countryCode;
    }
}
