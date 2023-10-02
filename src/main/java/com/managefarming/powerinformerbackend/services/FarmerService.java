package com.managefarming.powerinformerbackend.services;


import com.managefarming.powerinformerbackend.entities.Farmer;
import com.managefarming.powerinformerbackend.repositories.FarmerRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;


    public Long addFarmer(Farmer farmer) {

       Farmer result  =  farmerRepository.save(farmer);
       if(result==null){
           return null;
       }
       return result.getFarmerId();

    }

    public Farmer getFarmersById(Long farmerId) {
      Farmer farmer =   farmerRepository.findById(farmerId).get();
      if(farmer ==null) return null;

      return farmer;
    }
}
