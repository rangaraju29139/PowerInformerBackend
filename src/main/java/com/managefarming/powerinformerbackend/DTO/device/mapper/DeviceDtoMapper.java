package com.managefarming.powerinformerbackend.DTO.device.mapper;


import com.managefarming.powerinformerbackend.DTO.device.DeviceDto;
import com.managefarming.powerinformerbackend.entities.Device;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DeviceDtoMapper {

    public static DeviceDto maptoDeviceDto(Device device){
        return  DeviceDto.builder()
                .deviceId(device.getDeviceId())
                .deviceName(device.getDeviceName())
                .currentDeviceStatus(device.getCurrentDeviceStatus().toString())
                .alertStartTime(device.getAlertStartTime())
                .alertEndTime(device.getAlertEndTime())
                .isActivated(device.getIsActivated())
                .minutesDelayToNotify(device.getMinutesDelayToNotify())
                .numDaysLogKeeping(device.getNumDaysLogKeeping())
                .lastHeartBeatSignal(device.getLastHeartBeatSignal())
                .build();
       
    }
}
