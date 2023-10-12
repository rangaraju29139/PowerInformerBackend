package com.managefarming.powerinformerbackend.repositories.commandLineRunner;

import com.managefarming.powerinformerbackend.entities.ContactInfo;
import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.entities.Farm;
import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.enums.PowerStatus;
import com.managefarming.powerinformerbackend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@Component
public class InitialDataCommandLIneRunner implements CommandLineRunner {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    @Autowired
    private DeviceEventRepository deviceEventRepository;




    @Override
    public void run(String... args) throws Exception {

        Farmer farmer = Farmer.builder()
                .balance(100.0)
                .email("rangaraju29139@gmail.com")
                .countryCode("+91")
                .firstName("rangaraju")
                .lastName("penmetsa")
                .phoneNumber("9154644777")
                .password("123")
                .build();
        Farmer savedFarmer = farmerRepository.save(farmer);

        Farm farm = Farm.builder()
                .farmName("2 Acers")
                .farmer(savedFarmer)
                .locationDescription("near main road")
                .build();
        Farm savedFarm = farmRepository.save(farm);


        Device device = Device.builder()
                .deviceAuthCode("123")
                .deviceName("2 Acers monitor")
                .currentDeviceStatus(PowerStatus.NOT_AVAILABLE)
                .farmer(savedFarmer)
                .isActivated(true)
                .farm(savedFarm)
                .alertStartTime("00:00")
                .alertEndTime("00:00")
                .lastHeartBeatSignal(LocalDateTime.now().minusMinutes(30))
                .minutesDelayToNotify(1)
                .numDaysLogKeeping(1)
                .build();

        Device savedDevice = deviceRepository.save(device);

        List<ContactInfo> contactInfo = Arrays.asList(
                ContactInfo.builder().priority(1).contactName("rangaraju1").countryCode("+91").device(savedDevice).phoneNumber("9154644777").build(),
                ContactInfo.builder().priority(2).contactName("rangaraju2").countryCode("+91").device(savedDevice).phoneNumber("8341344777").build(),
                ContactInfo.builder().priority(3).contactName("rangaraju3").countryCode("+91").device(savedDevice).phoneNumber("9154644777").build(),
                ContactInfo.builder().priority(4).contactName("rangaraju4").countryCode("+91").device(savedDevice).phoneNumber("9154644777").build(),
                ContactInfo.builder().priority(5).contactName("rangaraju5").countryCode("+91").device(savedDevice).phoneNumber("9154644777").build()
        );
        List<ContactInfo> contactInfos = contactInfoRepository.saveAll(contactInfo);

        // device 2 in farm 1

        Device device2 = Device.builder()
                .deviceAuthCode("123")
                .deviceName("4 Acers monitor")
                .currentDeviceStatus(PowerStatus.NOT_AVAILABLE)
                .isActivated(true)
                .farmer(savedFarmer)
                .farm(savedFarm)
                .alertStartTime("00:00")
                .alertEndTime("00:00")
                .lastHeartBeatSignal(LocalDateTime.now().minusMinutes(30))
                .minutesDelayToNotify(1)
                .numDaysLogKeeping(1)
                .build();

        Device savedDevice2 = deviceRepository.save(device2);

        List<ContactInfo> contactInfo2 = Arrays.asList(
                ContactInfo.builder().priority(1).contactName("rangaraju1").countryCode("+91").device(savedDevice2).phoneNumber("9154644777").build(),
                ContactInfo.builder().priority(2).contactName("rangaraju2").countryCode("+91").device(savedDevice2).phoneNumber("8341344777").build(),
                ContactInfo.builder().priority(3).contactName("rangaraju3").countryCode("+91").device(savedDevice2).phoneNumber("9154644777").build(),
                ContactInfo.builder().priority(4).contactName("rangaraju4").countryCode("+91").device(savedDevice2).phoneNumber("9154644777").build(),
                ContactInfo.builder().priority(5).contactName("rangaraju5").countryCode("+91").device(savedDevice2).phoneNumber("9154644777").build()
        );
        List<ContactInfo> contactInfos2 = contactInfoRepository.saveAll(contactInfo2);


    }
}
