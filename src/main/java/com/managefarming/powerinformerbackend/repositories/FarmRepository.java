package com.managefarming.powerinformerbackend.repositories;

import com.managefarming.powerinformerbackend.entities.Farm;
import com.managefarming.powerinformerbackend.entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FarmRepository extends JpaRepository<Farm,Long> {

    List<Farm> findByFarmer(Farmer farmer);
}
