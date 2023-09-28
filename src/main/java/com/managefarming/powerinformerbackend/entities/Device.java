package com.managefarming.powerinformerbackend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.ZoneId;
import java.time.ZonedDateTime;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    @Id
    @GeneratedValue
    private long deviceId;

    @ManyToOne(targetEntity = Farm.class)
    private long farmId;

    private String name;


    private String deviceAuthCode;

    private boolean currentStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd@HH:mm:ss",locale = "en_IN")
    private ZonedDateTime lastHeartBeatSignal;







}
