package com.managefarming.powerinformerbackend.DTO.contactInfo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfoDto {

    private Long id;
    //should refer the device id in device table
    private Long DeviceId;

    private int priority;
    private String contactName;
    private String countryCode;
    private String phoneNumber;


}
