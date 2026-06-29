package com.CRM.Doctor_Patient_CRM_System.Repositry;

import com.CRM.Doctor_Patient_CRM_System.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepositry extends JpaRepository<Doctor,Long> {
}
