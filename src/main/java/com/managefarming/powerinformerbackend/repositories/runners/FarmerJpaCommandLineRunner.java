package com.managefarming.powerinformerbackend.repositories.runners;


import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.repositories.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FarmerJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private FarmerRepository farmerRepository;
    @Override
    public void run(String... args) throws Exception {
        farmerRepository.save(new Farmer("rangaraju","penmetsa","9154644777","+91"));
        farmerRepository.save(new Farmer("rangaraju2","penmetsa","9154644777","+91"));
        farmerRepository.save(new Farmer("rangaraju3","penmetsa","9154644777","+91"));

    }
}
