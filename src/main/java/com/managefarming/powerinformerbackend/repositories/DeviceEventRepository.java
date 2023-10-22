package com.managefarming.powerinformerbackend.repositories;

import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.entities.DeviceEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceEventRepository extends JpaRepository<DeviceEvent,Long> {

    List<DeviceEvent> findByDeviceOrderByEventTime(Device device);
}
