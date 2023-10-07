package com.managefarming.powerinformerbackend.DTO.deviceEvent.mappers;

import com.managefarming.powerinformerbackend.DTO.deviceEvent.DeviceEventDto;
import com.managefarming.powerinformerbackend.entities.DeviceEvent;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class DeviceEventDtoMapper {

    public static DeviceEventDto mapToDeviceEventDto(DeviceEvent deviceEvent){
        DeviceEventDto deviceEventDto = DeviceEventDto.builder()
                .deviceId(deviceEvent.getDevice().getDeviceId())
                .eventTime(deviceEvent.getEventTime())
                .eventType(deviceEvent.getEventType())
                .id(deviceEvent.getId())
                .build();
        return deviceEventDto;
    }
}
