package com.managefarming.powerinformerbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "farm")
public class Farm {


    @Id
    @GeneratedValue
    @Column(name = "farm_id")
    private long farmId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "farmer_id")
    private Farmer farmerId;

    @Column(name = "farm_name")
    private String farmName;

    @Column(name = "location_description")
    private String locationDescription;

    @JsonIgnore
    @OneToMany
    Set<Device> devicesList = new HashSet<>();
//
//    public Farm( farmerId, String name, String locationDescription) {
//        this.farmerId = farmerId;
//        this.name = name;
//        this.locationDescription = locationDescription;
//    }
}
