package com.managefarming.powerinformerbackend.entities;


import com.managefarming.powerinformerbackend.enums.DeviceEventType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeviceEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //should refer to the deviceid in the device entity
    @ManyToOne
    @JoinColumn(name ="device_id",referencedColumnName = "device_id",nullable = false)
    private Device device;
    private LocalDateTime eventTime ;
    @Enumerated(EnumType.STRING)
    private DeviceEventType eventType;
}
