package com.hospital.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String specialization;
    
    // New Fields for Advanced Doctor Portal
    private String photographUrl;
    private String dob;
    private String govId;
    private String address;
    private String education;
    private String experience;
    private String joiningDate;
    private String activeShifts;

    // Default constructor required by JPA
    public Doctor() {}

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getPhotographUrl() { return photographUrl; }
    public void setPhotographUrl(String photographUrl) { this.photographUrl = photographUrl; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getGovId() { return govId; }
    public void setGovId(String govId) { this.govId = govId; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }

    public String getJoiningDate() { return joiningDate; }
    public void setJoiningDate(String joiningDate) { this.joiningDate = joiningDate; }

    public String getActiveShifts() { return activeShifts; }
    public void setActiveShifts(String activeShifts) { this.activeShifts = activeShifts; }
}
