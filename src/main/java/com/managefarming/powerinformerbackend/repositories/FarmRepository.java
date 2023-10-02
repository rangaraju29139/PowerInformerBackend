package com.managefarming.powerinformerbackend.repositories;

import com.managefarming.powerinformerbackend.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FarmRepository extends JpaRepository<Farm,Long> {

   List<Farm> findByFarmerId(Long farmerId);
}
