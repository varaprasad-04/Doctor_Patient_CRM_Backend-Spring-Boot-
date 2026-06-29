package com.CRM.Doctor_Patient_CRM_System.Controller;

import com.CRM.Doctor_Patient_CRM_System.Model.Patient;
import com.CRM.Doctor_Patient_CRM_System.Services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientServices patientService;

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{patientId}")
    public Patient getPatientById(@PathVariable Long patientId) {
        return patientService.getPatientById(patientId);
    }

    @PutMapping("/{patientId}")
    public Patient updatePatient(@PathVariable Long patientId,
                                 @RequestBody Patient patient) {

        return patientService.updatePatient(patientId, patient);
    }

    @DeleteMapping("/{patientId}")
    public String deletePatient(@PathVariable Long patientId) {

        patientService.deletePatient(patientId);

        return "Patient Deleted Successfully";
    }
}
