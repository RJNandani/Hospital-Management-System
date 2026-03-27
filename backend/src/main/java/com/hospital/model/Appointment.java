package com.hospital.model;

import jakarta.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many appointments can belong to one patient
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    // Many appointments can belong to one doctor
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    private String appointmentDate; // Stored as YYYY-MM-DD
    private String appointmentTime;
    private String status; // "SCHEDULED", "COMPLETED", "CANCELLED"
    
    // New Clinical Fields
    @Column(length = 2000)
    private String diagnosis;
    @Column(length = 1000)
    private String prescription;
    @Column(length = 1000)
    private String suggestedTests;

    public Appointment() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    
    public String getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(String appointmentDate) { this.appointmentDate = appointmentDate; }
    
    public String getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(String appointmentTime) { this.appointmentTime = appointmentTime; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getPrescription() { return prescription; }
    public void setPrescription(String prescription) { this.prescription = prescription; }

    public String getSuggestedTests() { return suggestedTests; }
    public void setSuggestedTests(String suggestedTests) { this.suggestedTests = suggestedTests; }
}
