package com.sanjeev.learnings.springboot.patient.management.system.repository;

import com.sanjeev.learnings.springboot.patient.management.system.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    //JPA repository gives these method implementations at run time
    boolean existsByEmail(String email);
}
