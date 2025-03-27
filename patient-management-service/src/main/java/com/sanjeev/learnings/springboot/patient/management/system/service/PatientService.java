package com.sanjeev.learnings.springboot.patient.management.system.service;


import com.sanjeev.learnings.springboot.patient.management.system.dto.PatientResponseDTO;
import com.sanjeev.learnings.springboot.patient.management.system.mapper.PatientMapper;
import com.sanjeev.learnings.springboot.patient.management.system.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<PatientResponseDTO> getAllPatients() { return patientRepository.findAll().stream().map(PatientMapper::toDTO).collect(Collectors.toList()); }

}
