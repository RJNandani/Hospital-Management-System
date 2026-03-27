package com.hospital.controller;

import com.hospital.model.Appointment;
import com.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping
    public Appointment bookAppointment(@RequestBody Appointment appointment) {
        return appointmentService.bookAppointment(appointment);
    }

    @PutMapping("/{id}/status")
    public Appointment updateStatus(@PathVariable Long id, @RequestBody String status) {
        // Remove quotes if present in the request body
        String cleanStatus = status.replace("\"", "");
        return appointmentService.updateStatus(id, cleanStatus);
    }

    @PostMapping("/{id}/execute")
    public Appointment executeAppointment(@PathVariable Long id, @RequestBody Map<String, String> clinicalData) {
        String diagnosis = clinicalData.get("diagnosis");
        String prescription = clinicalData.get("prescription");
        String tests = clinicalData.get("tests");
        return appointmentService.executeAppointment(id, diagnosis, prescription, tests);
    }
}
