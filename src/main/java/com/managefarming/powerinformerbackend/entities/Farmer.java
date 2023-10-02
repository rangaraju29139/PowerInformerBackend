package com.managefarming.powerinformerbackend.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Farmer {


    @Id @GeneratedValue
    @Column(name = "farmer_id")
    private Long farmerId;

    @Column(name = "first_name",nullable = false)
    private String firstName;

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

    @OneToMany(targetEntity = Farm.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "farmer_id",referencedColumnName = "farmer_id")
    private List<Farm> farms;

    @Column(name = "balance")
    private Double balance;

//    public Farmer(String firstName, String lastName, String phoneNumber, String countryCode) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phoneNumber = phoneNumber;
//        this.countryCode = countryCode;
//    }
}
