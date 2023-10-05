package com.managefarming.powerinformerbackend.repositories;

import com.managefarming.powerinformerbackend.entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer,Long> {
     Farmer findByFarmerId(Farmer farmer);
}
