package com.CRM.Doctor_Patient_CRM_System.Controller;

import com.CRM.Doctor_Patient_CRM_System.Model.Appointment;
import com.CRM.Doctor_Patient_CRM_System.Services.AppointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentServices appointmentServices;

    // Book Appointment
    @PostMapping("/{doctorId}/{patientId}")
    public Appointment bookAppointment(@PathVariable Long doctorId,
                                       @PathVariable Long patientId,
                                       @RequestBody Appointment appointment) {

        return appointmentServices.bookAppointment(doctorId, patientId, appointment);
    }

    // Get All Appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {

        return appointmentServices.getAllAppointments();
    }

    // Get Appointment By Id
    @GetMapping("/{appointmentId}")
    public Appointment getAppointmentById(@PathVariable Long appointmentId) {

        return appointmentServices.getAppointmentById(appointmentId);
    }

    // Update Appointment
    @PutMapping("/{appointmentId}")
    public Appointment updateAppointment(@PathVariable Long appointmentId,
                                         @RequestBody Appointment appointment) {

        return appointmentServices.updateAppointment(appointmentId, appointment);
    }

    // Delete Appointment
    @DeleteMapping("/{appointmentId}")
    public String deleteAppointment(@PathVariable Long appointmentId) {

        appointmentServices.deleteAppointment(appointmentId);

        return "Appointment Deleted Successfully";
    }

    // Get Appointments of a Specific Doctor
    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsByDoctorId(@PathVariable Long doctorId) {
        return appointmentServices.getAppointmentsByDoctorId(doctorId);
    }

    // Get Appointments of a Specific Patient
    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable Long patientId) {
        return appointmentServices.getAppointmentsByPatientId(patientId);
    }

    // Accept Appointment
    @PutMapping("/{appointmentId}/accept")
    public Appointment acceptAppointment(@PathVariable Long appointmentId) {
        return appointmentServices.acceptAppointment(appointmentId);
    }

    // Reject Appointment
    @PutMapping("/{appointmentId}/reject")
    public Appointment rejectAppointment(@PathVariable Long appointmentId) {
        return appointmentServices.rejectAppointment(appointmentId);
    }

    // Complete Appointment
    @PutMapping("/{appointmentId}/complete")
    public Appointment completeAppointment(@PathVariable Long appointmentId,
                                           @RequestBody Appointment appointmentDetails) {
        return appointmentServices.completeAppointment(
                appointmentId,
                appointmentDetails.getDiagnosis(),
                appointmentDetails.getPrescription()
        );
    }
}
