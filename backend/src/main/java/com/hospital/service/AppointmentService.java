package com.hospital.service;

import com.hospital.dao.AppointmentDAO;
import com.hospital.dao.PatientDAO;
import com.hospital.model.Appointment;
import com.hospital.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentDAO appointmentDAO;

    @Autowired
    private PatientDAO patientDAO;

    public List<Appointment> getAllAppointments() {
        return appointmentDAO.findAll();
    }

    public Appointment bookAppointment(Appointment appointment) {
        appointment.setStatus("SCHEDULED");
        return appointmentDAO.save(appointment);
    }

    public Appointment updateStatus(Long id, String status) {
        Appointment appt = appointmentDAO.findById(id).orElse(null);
        if (appt != null) {
            appt.setStatus(status);
            return appointmentDAO.save(appt);
        }
        return null;
    }

    public Appointment executeAppointment(Long id, String diagnosis, String prescription, String tests) {
        Appointment appt = appointmentDAO.findById(id).orElse(null);
        if (appt != null) {
            appt.setStatus("COMPLETED");
            appt.setDiagnosis(diagnosis);
            appt.setPrescription(prescription);
            appt.setSuggestedTests(tests);
            
            // Sync with Patient Profile
            Patient p = appt.getPatient();
            if (p != null) {
                String existingHistory = p.getMedicalHistory() != null ? p.getMedicalHistory() : "";
                String newReport = (existingHistory.isEmpty() ? "" : existingHistory + ", ") + diagnosis;
                p.setMedicalHistory(newReport);
                p.setLastPrescription(prescription);
                if(tests != null && !tests.isEmpty()) {
                    p.setTestResults(tests);
                }
                
                patientDAO.save(p);
            }
            
            return appointmentDAO.save(appt);
        }
        return null;
    }
}
