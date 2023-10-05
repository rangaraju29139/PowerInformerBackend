package com.managefarming.powerinformerbackend.repositories;

import com.managefarming.powerinformerbackend.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Long> {
}
