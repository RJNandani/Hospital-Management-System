package com.hospital;

import com.hospital.dao.AppointmentDAO;
import com.hospital.dao.DoctorDAO;
import com.hospital.dao.PatientDAO;
import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private DoctorDAO doctorDAO;

    @Autowired
    private AppointmentDAO appointmentDAO;

    @Override
    public void run(String... args) throws Exception {
        // Only seed data if the database is completely empty
        if (doctorDAO.count() == 0 && patientDAO.count() == 0) {
            System.out.println("No data found! Seeding database with presentation-ready dummy data...");

            // Create Doctors
            Doctor doc1 = new Doctor("Sarah Walker", "Neurology");
            Doctor doc2 = new Doctor("Gregory House", "Diagnostic Medicine");
            Doctor doc3 = new Doctor("Derek Shepherd", "Neurosurgery");
            Doctor doc4 = new Doctor("Miranda Bailey", "General Surgery");

            doc1 = doctorDAO.save(doc1);
            doc2 = doctorDAO.save(doc2);
            doc3 = doctorDAO.save(doc3);
            doc4 = doctorDAO.save(doc4);

            // Create Patients
            Patient p1 = new Patient("John Doe", 45, "555-0101",
                    "Asthma, Hypertension. Had previous neurological checks.");
            Patient p2 = new Patient("Jane Smith", 29, "555-0102", "No significant medical history.");
            Patient p3 = new Patient("Robert Baratheon", 55, "555-0103",
                    "Heart Disease, Gout. Requires surgical consultation.");
            Patient p4 = new Patient("Arya Stark", 18, "555-0104", "Recent severe trauma. Stable condition.");
            Patient p5 = new Patient("Cersei Lannister", 42, "555-0105", "Frequent chronic migraines.");

            p1 = patientDAO.save(p1);
            p2 = patientDAO.save(p2);
            p3 = patientDAO.save(p3);
            p4 = patientDAO.save(p4);
            p5 = patientDAO.save(p5);

            // Create Appointments (Focusing heavily on multi-date history)

            // John Doe - 3 Appointments
            Appointment a1 = new Appointment();
            a1.setPatient(p1);
            a1.setDoctor(doc2);
            a1.setAppointmentDate("2026-01-10");
            a1.setAppointmentTime("10:00");
            a1.setStatus("COMPLETED");

            Appointment a2 = new Appointment();
            a2.setPatient(p1);
            a2.setDoctor(doc1);
            a2.setAppointmentDate("2026-02-15");
            a2.setAppointmentTime("14:30");
            a2.setStatus("COMPLETED");

            Appointment a3 = new Appointment();
            a3.setPatient(p1);
            a3.setDoctor(doc4);
            a3.setAppointmentDate("2026-04-12");
            a3.setAppointmentTime("09:00");
            a3.setStatus("SCHEDULED");

            // Jane Smith (Patient 2) - 2 Appointments
            Appointment a4 = new Appointment();
            a4.setPatient(p2);
            a4.setDoctor(doc4);
            a4.setAppointmentDate("2025-12-10");
            a4.setAppointmentTime("09:30");
            a4.setStatus("COMPLETED");

            Appointment a5 = new Appointment();
            a5.setPatient(p2);
            a5.setDoctor(doc1);
            a5.setAppointmentDate("2026-05-01");
            a5.setAppointmentTime("11:00");
            a5.setStatus("SCHEDULED");

            // Robert Baratheon (Patient 3) - 2 Appointments
            Appointment a6 = new Appointment();
            a6.setPatient(p3);
            a6.setDoctor(doc3);
            a6.setAppointmentDate("2026-02-28");
            a6.setAppointmentTime("15:00");
            a6.setStatus("COMPLETED");

            Appointment a7 = new Appointment();
            a7.setPatient(p3);
            a7.setDoctor(doc2);
            a7.setAppointmentDate("2026-04-20");
            a7.setAppointmentTime("10:00");
            a7.setStatus("SCHEDULED");

            appointmentDAO.save(a1);
            appointmentDAO.save(a2);
            appointmentDAO.save(a3);
            appointmentDAO.save(a4);
            appointmentDAO.save(a5);
            appointmentDAO.save(a6);
            appointmentDAO.save(a7);

            System.out.println(
                    "Presentation dummy data successfully seeded! Multiple patients have multi-date appointment history.");
        }
    }
}
