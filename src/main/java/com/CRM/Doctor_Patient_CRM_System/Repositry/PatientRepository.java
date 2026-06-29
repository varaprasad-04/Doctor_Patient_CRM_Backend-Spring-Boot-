package com.CRM.Doctor_Patient_CRM_System.Repositry;

import com.CRM.Doctor_Patient_CRM_System.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
