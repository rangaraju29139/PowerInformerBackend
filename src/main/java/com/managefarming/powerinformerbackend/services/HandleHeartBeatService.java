package com.managefarming.powerinformerbackend.services;


import com.managefarming.powerinformerbackend.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandleHeartBeatService {

    @Autowired
    private DeviceRepository deviceRepository;
}
