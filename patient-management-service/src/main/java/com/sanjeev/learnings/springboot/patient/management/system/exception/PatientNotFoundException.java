package com.sanjeev.learnings.springboot.patient.management.system.exception;

public class PatientNotFoundException extends Exception{
    public PatientNotFoundException(String message) {
        super(message);
    }
}
