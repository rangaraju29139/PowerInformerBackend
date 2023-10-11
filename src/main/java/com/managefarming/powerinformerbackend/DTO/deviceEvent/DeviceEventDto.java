package com.managefarming.powerinformerbackend.DTO.deviceEvent;


import com.managefarming.powerinformerbackend.enums.DeviceEventType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceEventDto {

    private Long id;
    private Long deviceId;
    private LocalDateTime eventTime;
    private DeviceEventType eventType;



}
