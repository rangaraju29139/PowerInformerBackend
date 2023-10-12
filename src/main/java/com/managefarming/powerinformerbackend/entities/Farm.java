package com.managefarming.powerinformerbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "farm")
public class Farm {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "farm_id")
    private long farmId;

    @ManyToOne
    @JoinColumn(name = "farmer_id",referencedColumnName = "farmer_id",nullable = false)
    private Farmer farmer;


    @Column(name = "farm_name")
    private String farmName;

    @Column(name = "location_description")
    private String locationDescription;


//
//    public Farm( farmerId, String name, String locationDescription) {
//        this.farmerId = farmerId;
//        this.name = name;
//        this.locationDescription = locationDescription;
//    }
}
