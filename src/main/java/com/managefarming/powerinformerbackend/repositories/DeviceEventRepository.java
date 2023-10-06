package com.managefarming.powerinformerbackend.repositories;

import com.managefarming.powerinformerbackend.entities.DeviceEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceEventRepository extends JpaRepository<DeviceEvent,Long> {

    
}
