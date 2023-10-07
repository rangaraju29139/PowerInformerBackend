package com.managefarming.powerinformerbackend.DTO.device.mapper;


import com.managefarming.powerinformerbackend.DTO.device.DeviceRequestDto;
import com.managefarming.powerinformerbackend.entities.Device;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DeviceRequestDtoMapper {

    public static Device maptoDevice(DeviceRequestDto deviceRequestDto){
        Device device = Device.builder()
                .deviceName(deviceRequestDto.getDeviceName())
                .currentDeviceStatus(deviceRequestDto.getCurrentDeviceStatus())
                .alertStartTime(deviceRequestDto.getAlertStartTime())
                .alertEndTime(deviceRequestDto.getAlertEndTime())
                .isActivated(deviceRequestDto.isActivated())
                .minutesDelayToNotify(deviceRequestDto.getMinutesDelayToNotify())
                .numDaysLogKeeping(deviceRequestDto.getNumDaysLogKeeping())
                .lastHeartBeatSignal(ZonedDateTime.now(ZoneId.of("Asia/Calcutta")))
                .build();
        return device;
    }
}
