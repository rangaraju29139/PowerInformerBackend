package com.managefarming.powerinformerbackend.services;


import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.repositories.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerService {


    @Autowired
    private FarmerRepository farmerRepository;



    public Farmer getFarmerByFarmerId(long farmerId){
        return farmerRepository.findByFarmerId(farmerId);
    }
}
