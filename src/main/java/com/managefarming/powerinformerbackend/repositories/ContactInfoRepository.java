package com.managefarming.powerinformerbackend.repositories;

import com.managefarming.powerinformerbackend.entities.ContactInfo;
import com.managefarming.powerinformerbackend.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactInfoRepository extends JpaRepository<ContactInfo,Long> {

    List<ContactInfo> findAllByDevice(Device device);
}
