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
public class Farm {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long farmId;

    private String name;
    private String locationDescription;

}
