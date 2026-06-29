package com.CRM.Doctor_Patient_CRM_System.Services;

import com.CRM.Doctor_Patient_CRM_System.Model.Patient;
import com.CRM.Doctor_Patient_CRM_System.Repositry.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServices {
    @Autowired
    private PatientRepository patientRepository;
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long patientId) {

        Optional<Patient> patient = patientRepository.findById(patientId);

        if (patient.isPresent()) {
            return patient.get();
        }

        return null;
    }
    public Patient updatePatient(Long patientId, Patient patient) {

        Optional<Patient> existingPatient = patientRepository.findById(patientId);

        if (existingPatient.isPresent()) {

            Patient updatePatient = existingPatient.get();

            updatePatient.setName(patient.getName());
            updatePatient.setEmail(patient.getEmail());
            updatePatient.setPassword(patient.getPassword());
            updatePatient.setPhone(patient.getPhone());
            updatePatient.setAge(patient.getAge());
            updatePatient.setGender(patient.getGender());
            updatePatient.setBloodGroup(patient.getBloodGroup());
            updatePatient.setMedicalHistory(patient.getMedicalHistory());

            return patientRepository.save(updatePatient);
        }

        return null;
    }
    public void deletePatient(Long patientId) {

        patientRepository.deleteById(patientId);

    }

}
