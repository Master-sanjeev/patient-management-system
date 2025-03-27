package com.sanjeev.learnings.springboot.patient.management.system.mapper;

import com.sanjeev.learnings.springboot.patient.management.system.dto.PatientResponseDTO;
import com.sanjeev.learnings.springboot.patient.management.system.model.Patient;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patient.getName());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientDTO;
    }
}
