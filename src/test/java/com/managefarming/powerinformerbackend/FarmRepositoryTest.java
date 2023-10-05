package com.managefarming.powerinformerbackend;


import com.managefarming.powerinformerbackend.entities.Farm;
import com.managefarming.powerinformerbackend.repositories.FarmRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FarmRepositoryTest {

    @Autowired
    FarmRepository farmRepository;


    @BeforeEach
    public void setUp(){




    }


    @Test
    public void createFarmTest(){

    }

}
