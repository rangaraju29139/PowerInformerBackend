package com.managefarming.powerinformerbackend.services;

import com.managefarming.powerinformerbackend.entities.Farm;
import com.managefarming.powerinformerbackend.repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


@Service
public class FarmService {


    @Autowired
    private FarmRepository farmRepository;

    public Farm addFarm( Farm farm) {
        Farm result = farmRepository.save(farm);
        if(result == null){
            return null;
        }
        return result;
    }

    public List<Farm> findAllFarmsByFarmerId(Long farmerId) {
        List<Farm> result = farmRepository.findByFarmerId(farmerId);
        if(result.size() == 0){
            return null;
        }
        return result;
    }
}
