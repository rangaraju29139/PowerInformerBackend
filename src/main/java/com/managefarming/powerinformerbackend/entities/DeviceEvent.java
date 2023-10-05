package com.managefarming.powerinformerbackend.entities;


import com.managefarming.powerinformerbackend.enums.DeviceEventType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class DeviceEvent {

    @Id
    private Long id;

    //should refer to the deviceid in the device entity
    private Long deviceId;
    private LocalDateTime eventTime;
    @Enumerated(EnumType.STRING)
    private DeviceEventType eventType;
}
