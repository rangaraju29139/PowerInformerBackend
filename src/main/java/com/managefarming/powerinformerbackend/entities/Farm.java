package com.managefarming.powerinformerbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.core.annotation.Order;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @GeneratedValue
    @Column(name = "farm_id")
    private long farmId;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

//    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
//    private Set<Device> devices = new HashSet<>();


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
