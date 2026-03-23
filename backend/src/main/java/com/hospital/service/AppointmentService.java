package com.hospital.service;

import com.hospital.dao.AppointmentDAO;
import com.hospital.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentDAO appointmentDAO;

    public List<Appointment> getAllAppointments() {
        return appointmentDAO.findAll();
    }

    public Appointment bookAppointment(Appointment appointment) {
        appointment.setStatus("SCHEDULED");
        return appointmentDAO.save(appointment);
    }
}
