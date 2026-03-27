package com.hospital.model;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String contactNumber;
    private String medicalHistory;
    
    // New Fields for Patient Viewer
    private String lastPrescription;
    private String testResults;

    // Default constructor
    public Patient() {}

    public Patient(String name, int age, String contactNumber, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalHistory = medicalHistory;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getMedicalHistory() { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }

    public String getLastPrescription() { return lastPrescription; }
    public void setLastPrescription(String lastPrescription) { this.lastPrescription = lastPrescription; }

    public String getTestResults() { return testResults; }
    public void setTestResults(String testResults) { this.testResults = testResults; }
}
