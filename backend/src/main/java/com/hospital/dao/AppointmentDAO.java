package com.hospital.dao;

import com.hospital.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentDAO extends JpaRepository<Appointment, Long> {
}
