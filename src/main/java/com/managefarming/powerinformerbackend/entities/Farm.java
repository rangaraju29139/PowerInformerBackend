package com.managefarming.powerinformerbackend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Farm {


    @Id
    @GeneratedValue
    private long farmId;

    @ManyToOne(targetEntity = Farmer.class)
    private long farmerId;

    private String name;
    private String locationDescription;


}
