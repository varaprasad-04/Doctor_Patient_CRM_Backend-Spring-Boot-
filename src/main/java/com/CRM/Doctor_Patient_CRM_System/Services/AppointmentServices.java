package com.CRM.Doctor_Patient_CRM_System.Services;

import com.CRM.Doctor_Patient_CRM_System.Model.Appointment;
import com.CRM.Doctor_Patient_CRM_System.Model.Doctor;
import com.CRM.Doctor_Patient_CRM_System.Model.Patient;
import com.CRM.Doctor_Patient_CRM_System.Repositry.AppointmentRepository;
import com.CRM.Doctor_Patient_CRM_System.Repositry.DoctorRepositry;
import com.CRM.Doctor_Patient_CRM_System.Repositry.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServices {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepositry doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    public Appointment bookAppointment(Long doctorId, Long patientId, Appointment appointment) {

        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        Optional<Patient> patient = patientRepository.findById(patientId);

        if (doctor.isPresent() && patient.isPresent()) {

            appointment.setDoctor(doctor.get());
            appointment.setPatient(patient.get());
            appointment.setStatus("BOOKED");

            return appointmentRepository.save(appointment);
        }

        return null;
    }
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long appointmentId) {

        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);

        if (appointment.isPresent()) {
            return appointment.get();
        }

        return null;
    }

    public Appointment updateAppointment(Long appointmentId, Appointment appointment) {

        Optional<Appointment> existingAppointment =
                appointmentRepository.findById(appointmentId);

        if (existingAppointment.isPresent()) {

            Appointment updateAppointment = existingAppointment.get();

            updateAppointment.setAppointmentDate(appointment.getAppointmentDate());
            updateAppointment.setAppointmentTime(appointment.getAppointmentTime());
            updateAppointment.setReason(appointment.getReason());
            updateAppointment.setStatus(appointment.getStatus());
            updateAppointment.setDiagnosis(appointment.getDiagnosis());
            updateAppointment.setPrescription(appointment.getPrescription());

            return appointmentRepository.save(updateAppointment);
        }

        return null;
    }

    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorDoctorId(doctorId);
    }

    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientPatientId(patientId);
    }

    public Appointment acceptAppointment(Long appointmentId) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(appointmentId);
        if (existingAppointment.isPresent()) {
            Appointment appointment = existingAppointment.get();
            appointment.setStatus("ACCEPTED");
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    public Appointment rejectAppointment(Long appointmentId) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(appointmentId);
        if (existingAppointment.isPresent()) {
            Appointment appointment = existingAppointment.get();
            appointment.setStatus("REJECTED");
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    public Appointment completeAppointment(Long appointmentId, String diagnosis, String prescription) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(appointmentId);
        if (existingAppointment.isPresent()) {
            Appointment appointment = existingAppointment.get();
            appointment.setDiagnosis(diagnosis);
            appointment.setPrescription(prescription);
            appointment.setStatus("COMPLETED");
            return appointmentRepository.save(appointment);
        }
        return null;
    }
}
