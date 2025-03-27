package com.sanjeev.learnings.springboot.patient.management.system.service;


import com.sanjeev.learnings.springboot.patient.management.system.dto.PatientRequestDTO;
import com.sanjeev.learnings.springboot.patient.management.system.dto.PatientResponseDTO;
import com.sanjeev.learnings.springboot.patient.management.system.exception.EmailAlreadyExistsException;
import com.sanjeev.learnings.springboot.patient.management.system.mapper.PatientMapper;
import com.sanjeev.learnings.springboot.patient.management.system.model.Patient;
import com.sanjeev.learnings.springboot.patient.management.system.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<PatientResponseDTO> getAllPatients() { return patientRepository.findAll().stream().map(PatientMapper::toDTO).collect(Collectors.toList()); }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) throws EmailAlreadyExistsException {
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Patient with email " + patientRequestDTO.getEmail() + " already exists");
        }
        Patient patient = PatientMapper.toModel(patientRequestDTO);
        if (patient.getId() == null) {
            patient.setId(UUID.randomUUID().toString());
        }
        patientRepository.save(patient);
        return PatientMapper.toDTO(patient);
    }

}
