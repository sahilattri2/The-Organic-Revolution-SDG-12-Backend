package com.example.Organic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String farmerName;
    private String contactNumber;
    private String farmerGender;
    private LocalDateTime preferredAppointmentTime;
    private String preferredMode;
    private String email;

    public Visit() {
    }

    public Visit(String farmerName, String contactNumber, String farmerGender, LocalDateTime preferredAppointmentTime, String preferredMode, String email) {
        this.farmerName = farmerName;
        this.contactNumber = contactNumber;
        this.farmerGender = farmerGender;
        this.preferredAppointmentTime = preferredAppointmentTime;
        this.preferredMode = preferredMode;
        this.email = email;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFarmerGender() {
        return farmerGender;
    }

    public void setFarmerGender(String farmerGender) {
        this.farmerGender = farmerGender;
    }

    public LocalDateTime getPreferredAppointmentTime() {
        return preferredAppointmentTime;
    }

    public void setPreferredAppointmentTime(LocalDateTime preferredAppointmentTime) {
        this.preferredAppointmentTime = preferredAppointmentTime;
    }

    public String getPreferredMode() {
        return preferredMode;
    }

    public void setPreferredMode(String preferredMode) {
        this.preferredMode = preferredMode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", farmerName='" + farmerName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", farmerGender='" + farmerGender + '\'' +
                ", preferredAppointmentTime=" + preferredAppointmentTime +
                ", preferredMode='" + preferredMode + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
