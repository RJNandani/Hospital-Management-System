package com.hospital.dao;

import com.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDAO extends JpaRepository<Patient, Long> {
}
