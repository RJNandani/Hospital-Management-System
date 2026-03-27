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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
            doc1.setPhotographUrl(
                    "https://images.unsplash.com/photo-1559839734-2b71ea197ec2?q=80&w=300&h=300&auto=format&fit=crop");
            doc1.setDob("1980-05-15");
            doc1.setGovId("GOV-12345");
            doc1.setAddress("123 Medical Plaza, Suite 100");
            doc1.setEducation("MD - Harvard Medical School, Residency at Mass Gen");
            doc1.setExperience("15 Years Specialized");
            doc1.setJoiningDate("2015-06-01");
            doc1.setActiveShifts("Monday 10:00-14:00, Wednesday 16:00-20:00");

            Doctor doc2 = new Doctor("Gregory House", "Diagnostic Medicine");
            doc2.setPhotographUrl(
                    "https://images.unsplash.com/photo-1612349317146-155ba7216857?q=80&w=300&h=300&auto=format&fit=crop");
            doc2.setDob("1959-06-11");
            doc2.setGovId("GOV-99999");
            doc2.setAddress("Princeton-Plainsboro Teaching Hospital");
            doc2.setEducation("MD - Johns Hopkins University");
            doc2.setExperience("30 Years Specialized");
            doc2.setJoiningDate("2004-11-16");
            doc2.setActiveShifts("Tuesday 08:00-12:00, Thursday 13:00-18:00");

            Doctor doc3 = new Doctor("Derek Shepherd", "Neurosurgery");
            doc3.setPhotographUrl(
                    "https://images.unsplash.com/photo-1622253692010-333f2da6031d?q=80&w=300&h=300&auto=format&fit=crop");
            doc3.setDob("1966-07-20");
            doc3.setGovId("GOV-77777");
            doc3.setAddress("Seattle Grace Hospital");
            doc3.setEducation("MD - Columbia University");
            doc3.setExperience("22 Years Specialized");
            doc3.setJoiningDate("2005-03-27");
            doc3.setActiveShifts("Monday 07:00-15:00, Friday 09:00-17:00");

            Doctor doc4 = new Doctor("Miranda Bailey", "General Surgery");
            doc4.setPhotographUrl(
                    "https://images.unsplash.com/photo-1594824432258-0ceb5e0c52f6?q=80&w=300&h=300&auto=format&fit=crop");
            doc4.setDob("1971-08-27");
            doc4.setGovId("GOV-88888");
            doc4.setAddress("Seattle Grace Hospital");
            doc4.setEducation("MD - Wellesley College");
            doc4.setExperience("20 Years Specialized");
            doc4.setJoiningDate("2005-03-27");
            doc4.setActiveShifts("Wednesday 09:00-17:00, Thursday 18:00-22:00");

            doc1 = doctorDAO.save(doc1);
            doc2 = doctorDAO.save(doc2);
            doc3 = doctorDAO.save(doc3);
            doc4 = doctorDAO.save(doc4);

            // Create Patients
            Patient p1 = new Patient("John Doe", 45, "555-0101",
                    "Asthma, Hypertension. Had previous neurological checks.");
            p1.setLastPrescription("Albuterol Inhaler (PRN), Lisinopril 10mg daily.");
            p1.setTestResults("Blood Pressure: 135/85 (Elevated). Pulmonary Function: Normal.");

            Patient p2 = new Patient("Jane Smith", 29, "555-0102", "No significant medical history.");
            p2.setLastPrescription("Prenatal Vitamins.");
            p2.setTestResults("All recent blood work within perfectly normal ranges.");

            Patient p3 = new Patient("Robert Baratheon", 55, "555-0103",
                    "Heart Disease, Gout. Requires surgical consultation.");
            p3.setLastPrescription("Allopurinol 100mg, Atorvastatin 200mg.");
            p3.setTestResults("Uric Acid: 8.5 mg/dL (High). ECG shows minor arrhythmia.");

            Patient p4 = new Patient("Arya Stark", 18, "555-0104", "Recent severe trauma. Stable condition.");
            p4.setLastPrescription("Ibuprofen 400mg for pain.");
            p4.setTestResults("X-Ray: Clean. MRI: Clean.");

            Patient p5 = new Patient("Cersei Lannister", 42, "555-0105", "Frequent chronic migraines.");
            p5.setLastPrescription("Sumatriptan 50mg.");
            p5.setTestResults("Neurological scan shows no structural abnormalities.");

            p1 = patientDAO.save(p1);
            p2 = patientDAO.save(p2);
            p3 = patientDAO.save(p3);
            p4 = patientDAO.save(p4);
            p5 = patientDAO.save(p5);

            // Create Appointments (Focusing heavily on multi-date history)

            // Dynamic Dates setup
            LocalDate today = LocalDate.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // John Doe - 3 Appointments
            Appointment a1 = new Appointment();
            a1.setPatient(p1);
            a1.setDoctor(doc2);
            a1.setAppointmentDate(today.minusDays(5).format(fmt));
            a1.setAppointmentTime("10:00");
            a1.setStatus("COMPLETED");

            Appointment a2 = new Appointment();
            a2.setPatient(p1);
            a2.setDoctor(doc1);
            a2.setAppointmentDate(today.minusDays(1).format(fmt));
            a2.setAppointmentTime("14:30");
            a2.setStatus("COMPLETED");

            Appointment a3 = new Appointment();
            a3.setPatient(p1);
            a3.setDoctor(doc4);
            a3.setAppointmentDate(today.plusDays(2).format(fmt));
            a3.setAppointmentTime("09:00");
            a3.setStatus("SCHEDULED");

            // Jane Smith (Patient 2) - 2 Appointments
            Appointment a4 = new Appointment();
            a4.setPatient(p2);
            a4.setDoctor(doc4);
            a4.setAppointmentDate(today.minusDays(10).format(fmt));
            a4.setAppointmentTime("09:30");
            a4.setStatus("COMPLETED");

            Appointment a5 = new Appointment();
            a5.setPatient(p2);
            a5.setDoctor(doc1);
            a5.setAppointmentDate(today.plusDays(5).format(fmt));
            a5.setAppointmentTime("11:00");
            a5.setStatus("SCHEDULED");

            // Robert Baratheon (Patient 3) - 2 Appointments
            Appointment a6 = new Appointment();
            a6.setPatient(p3);
            a6.setDoctor(doc3);
            a6.setAppointmentDate(today.minusDays(2).format(fmt));
            a6.setAppointmentTime("15:00");
            a6.setStatus("COMPLETED");

            Appointment a7 = new Appointment();
            a7.setPatient(p3);
            a7.setDoctor(doc2);
            a7.setAppointmentDate(today.plusDays(1).format(fmt));
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
