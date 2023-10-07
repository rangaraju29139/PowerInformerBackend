package com.managefarming.powerinformerbackend.DTO.deviceEvent;


import com.managefarming.powerinformerbackend.enums.DeviceEventType;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceEventDto {

    private Long id;
    private Long deviceId;
    private ZonedDateTime eventTime;
    private DeviceEventType eventType;



}
