package com.managefarming.powerinformerbackend.DTO.device;

import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeviceDto {

    private Long deviceId;
    private String deviceName;
    private String currentDeviceStatus;
    private ZonedDateTime lastHeartBeatSignal;
    private boolean isActivated;
    private String alertStartTime;
    private String alertEndTime;
    private int minutesDelayToNotify;
    private int numDaysLogKeeping;

}
