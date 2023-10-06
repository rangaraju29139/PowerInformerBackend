package com.managefarming.powerinformerbackend.services;


import com.managefarming.powerinformerbackend.DTO.contactInfo.ContactInfoDto;
import com.managefarming.powerinformerbackend.DTO.contactInfo.mapper.ContactInfoDtoMapper;
import com.managefarming.powerinformerbackend.entities.ContactInfo;
import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.exceptions.ContactInfoNotCreatedException;
import com.managefarming.powerinformerbackend.repositories.ContactInfoRepository;
import com.managefarming.powerinformerbackend.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactInfoService {

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    @Autowired
    private DeviceRepository deviceRepository;


    public List<ContactInfoDto> createDeviceContactInfo(Long deviceId, List<ContactInfo> contactInfo) throws ContactInfoNotCreatedException {
        Device device = deviceRepository.findById(deviceId).get();

        contactInfo.forEach(contact -> contact.setDevice(device));
        contactInfoRepository.saveAll(contactInfo);
        List<ContactInfoDto> contactInfoDtoList = contactInfo.stream().map(contact -> ContactInfoDtoMapper.maptoContactInfoDto(contact)).collect(Collectors.toList());

        if(contactInfoDtoList == null){
            throw new ContactInfoNotCreatedException("contact Info Not created");
        }

        return contactInfoDtoList;

    }
}
