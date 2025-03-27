package com.sanjeev.learnings.springboot.patient.management.system.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Patient {

    @Id
    private UUID id;


}
