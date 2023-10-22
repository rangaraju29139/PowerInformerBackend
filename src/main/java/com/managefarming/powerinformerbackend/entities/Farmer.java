package com.managefarming.powerinformerbackend.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Farmer {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "farmer_id")
    private Long farmerId;

    @NotNull
    @Size(min=2)
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(name = "country_code",nullable = false)
    private String countryCode;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;


    @Column(name = "balance")
    private Double balance;

//    public Farmer(String firstName, String lastName, String phoneNumber, String countryCode) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phoneNumber = phoneNumber;
//        this.countryCode = countryCode;
//    }
}
