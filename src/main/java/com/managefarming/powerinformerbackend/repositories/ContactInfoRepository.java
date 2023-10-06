package com.managefarming.powerinformerbackend.repositories;

import com.managefarming.powerinformerbackend.entities.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInfoRepository extends JpaRepository<ContactInfo,Long> {

}
