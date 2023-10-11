package com.managefarming.powerinformerbackend.DTO.device.mapper;


import com.managefarming.powerinformerbackend.DTO.device.DeviceRequestDto;
import com.managefarming.powerinformerbackend.entities.Device;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DeviceRequestDtoMapper {

    public static Device maptoDevice(DeviceRequestDto deviceRequestDto){
       return Device.builder()
                .deviceName(deviceRequestDto.getDeviceName())
                .currentDeviceStatus(deviceRequestDto.getCurrentDeviceStatus())
                .alertStartTime(deviceRequestDto.getAlertStartTime())
                .alertEndTime(deviceRequestDto.getAlertEndTime())
                .isActivated(deviceRequestDto.isActivated())
                .minutesDelayToNotify(deviceRequestDto.getMinutesDelayToNotify())
                .numDaysLogKeeping(deviceRequestDto.getNumDaysLogKeeping())
                .lastHeartBeatSignal(LocalDateTime.now())
                .build();

    }
}
