package com.hospital.service;

import com.hospital.dao.PatientDAO;
import com.hospital.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientDAO patientDAO;

    public List<Patient> getAllPatients() {
        return patientDAO.findAll();
    }

    public Patient addPatient(Patient patient) {
        return patientDAO.save(patient);
    }
}
