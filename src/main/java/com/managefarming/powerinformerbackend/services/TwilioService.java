package com.managefarming.powerinformerbackend.services;

import com.managefarming.powerinformerbackend.DTO.contactInfo.ContactInfoDto;
import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.enums.DeviceEventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwilioService {

    @Autowired
    private ContactInfoService contactInfoService;


    public void sendInformation(Device device, DeviceEventType deviceEventType) {
        List<ContactInfoDto> contactList= contactInfoService.getAllContactInfoByDeviceId(device.getDeviceId());

    }


}
