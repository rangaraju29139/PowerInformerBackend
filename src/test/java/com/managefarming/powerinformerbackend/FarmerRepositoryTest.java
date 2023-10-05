package com.managefarming.powerinformerbackend;

import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.repositories.FarmerRepository;
import org.aspectj.lang.annotation.Before;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FarmerRepositoryTest {

    @Autowired
    private FarmerRepository farmerRepository;

    private Farmer farmer;
    @BeforeEach
    public void setUp(){
       farmer = Farmer.builder()
               .countryCode("+91")
               .email("rangaraju29139@gmail.com")
               .password("123")
               .firstName("rangaraju")
               .lastName("penmetsa")
               .phoneNumber("9154644777")
               .balance(100.0)
               .build();
    }

    @Test
    public void create_farmer_test(){
        Farmer result = farmerRepository.save(farmer);
        assertThat(result).isNotNull();
        assertThat(result.getFarmerId()).isEqualTo(farmer.getFarmerId());
        assertThat(result.getEmail()).isEqualTo(farmer.getEmail());

        //delete farmer created
        farmerRepository.deleteById(result.getFarmerId());
        assertThat(farmerRepository.findById(result.getFarmerId())).isEmpty();
    }

    @Test
    public void get_farmer_by_id_test(){

        Farmer result = farmerRepository.save(farmer);
        assertThat(result).isNotNull();
        assertThat(result.getFarmerId()).isEqualTo(farmer.getFarmerId());
        assertThat(result.getEmail()).isEqualTo(farmer.getEmail());

        Farmer result1= farmerRepository.findById(result.getFarmerId()).stream().findFirst().get();
        assertThat(result1.getFarmerId()).isEqualTo(result.getFarmerId());
        assertThat(result1.getEmail()).isEqualTo(farmer.getEmail());
        assertThat(result1.getPhoneNumber()).isEqualTo(farmer.getPhoneNumber());


        //delete farmer created
        farmerRepository.deleteById(result.getFarmerId());
        assertThat(farmerRepository.findById(result.getFarmerId())).isEmpty();

    }
}
