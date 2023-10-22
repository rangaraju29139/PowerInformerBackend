package com.managefarming.powerinformerbackend.DTO.device;

import com.managefarming.powerinformerbackend.enums.PowerStatus;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeviceRequestDto {

    private String deviceName;
    private PowerStatus currentDeviceStatus;
    private boolean isActivated;
    private String alertStartTime;
    private String alertEndTime;
    private int minutesDelayToNotify;
    private int numDaysLogKeeping;
    private String deviceAuthCode;

}
