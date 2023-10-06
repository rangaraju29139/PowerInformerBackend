package com.managefarming.powerinformerbackend.DTO.contactInfo.mapper;

import com.managefarming.powerinformerbackend.DTO.contactInfo.ContactInfoDto;
import com.managefarming.powerinformerbackend.entities.ContactInfo;

public class ContactInfoDtoMapper {

    public static ContactInfoDto maptoContactInfoDto(ContactInfo contactInfo){
        ContactInfoDto contactInfoDto = ContactInfoDto.builder()
                .id(contactInfo.getId())
                .contactName(contactInfo.getContactName())
                .countryCode(contactInfo.getCountryCode())
                .phoneNumber(contactInfo.getPhoneNumber())
                .priority(contactInfo.getPriority())
                .DeviceId(contactInfo.getDevice().getDeviceId())
                .build();

        return contactInfoDto;
    }
}
