package com.managefarming.powerinformerbackend.entities;


import com.managefarming.powerinformerbackend.enums.DeviceEventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //should refer to the deviceid in the device entity
    @ManyToOne
    @JoinColumn(name ="device_id",referencedColumnName = "device_id",nullable = false)
    private Device device;
    private ZonedDateTime eventTime;
    @Enumerated(EnumType.STRING)
    private DeviceEventType eventType;
}
