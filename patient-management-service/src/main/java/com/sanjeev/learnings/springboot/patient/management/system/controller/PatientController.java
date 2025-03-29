package com.sanjeev.learnings.springboot.patient.management.system.controller;

import com.sanjeev.learnings.springboot.patient.management.system.dto.PatientRequestDTO;
import com.sanjeev.learnings.springboot.patient.management.system.dto.PatientResponseDTO;
import com.sanjeev.learnings.springboot.patient.management.system.dto.validators.CreatePatientValidationGroup;
import com.sanjeev.learnings.springboot.patient.management.system.exception.EmailAlreadyExistsException;
import com.sanjeev.learnings.springboot.patient.management.system.exception.PatientNotFoundException;
import com.sanjeev.learnings.springboot.patient.management.system.service.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    /**
     * using two groups to validate the request
     * */
    @PostMapping
    public ResponseEntity<PatientResponseDTO> addPatient(@Validated({Default.class, CreatePatientValidationGroup.class}) @RequestBody PatientRequestDTO patientRequestDTO) throws EmailAlreadyExistsException {
        return ResponseEntity.ok(patientService.createPatient(patientRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient( @PathVariable("id") String id, @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO) throws EmailAlreadyExistsException, PatientNotFoundException {
        PatientResponseDTO patientResponseDTO = patientService.updatePatient(id, patientRequestDTO);
        return ResponseEntity.ok(patientResponseDTO);
    }
}
