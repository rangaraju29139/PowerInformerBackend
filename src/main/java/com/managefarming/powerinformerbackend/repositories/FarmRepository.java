package com.managefarming.powerinformerbackend.repositories;

import com.managefarming.powerinformerbackend.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm,Long> {

}
