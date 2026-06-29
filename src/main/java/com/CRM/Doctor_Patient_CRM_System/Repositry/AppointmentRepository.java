package com.CRM.Doctor_Patient_CRM_System.Repositry;

import com.CRM.Doctor_Patient_CRM_System.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findByDoctorDoctorId(Long doctorId);
    List<Appointment> findByPatientPatientId(Long patientId);
}
