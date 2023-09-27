package com.managefarming.powerinformerbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@Entity
@Getter
@Setter
@ToString
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long deviceId;

    private String name;

    @GeneratedValue(strategy = GenerationType.UUID)
    private String deviceAuthCode;

    private boolean currentStatus;




}
