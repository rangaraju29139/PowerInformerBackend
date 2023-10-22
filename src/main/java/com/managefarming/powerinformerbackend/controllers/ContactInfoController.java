package com.managefarming.powerinformerbackend.controllers;


import com.managefarming.powerinformerbackend.DTO.contactInfo.ContactInfoDto;
import com.managefarming.powerinformerbackend.entities.ContactInfo;
import com.managefarming.powerinformerbackend.exceptions.ContactInfoNotCreatedException;
import com.managefarming.powerinformerbackend.exceptions.ContactInfoNotFoundException;
import com.managefarming.powerinformerbackend.services.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class
ContactInfoController {

    @Autowired
    private ContactInfoService contactInfoService;

  @RequestMapping(value = "/devices/{deviceId}/contact-info",method = RequestMethod.POST)
    public ResponseEntity<List<ContactInfoDto>> createDeviceContactInfo(@PathVariable Long deviceId, @RequestBody List<ContactInfo> contactInfo) throws ContactInfoNotFoundException,ContactInfoNotCreatedException {
      List<ContactInfoDto> contactInfoDtos = contactInfoService.createDeviceContactInfo(deviceId, contactInfo);
      if(contactInfoDtos == null){
          throw new ContactInfoNotFoundException("ContactInfo with deviceId " + deviceId + "not found");
      }
      return ResponseEntity.ok(contactInfoDtos);
  }

    @RequestMapping(value = "/devices/{deviceId}/contact-info", method = RequestMethod.GET)
    public ResponseEntity<List<ContactInfoDto>> getAllContactInfoByDeviceId(@PathVariable  Long deviceId) throws ContactInfoNotFoundException {
        List<ContactInfoDto> contactInfo = contactInfoService.getAllContactInfoByDeviceId(deviceId);

        if(contactInfo == null){
            throw new ContactInfoNotFoundException("contact info with device id " + deviceId + " not found");
        }
        return ResponseEntity.ok(contactInfo);
    }

}
