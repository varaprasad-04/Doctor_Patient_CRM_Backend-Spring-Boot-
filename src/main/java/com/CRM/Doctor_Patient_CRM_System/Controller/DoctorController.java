package com.CRM.Doctor_Patient_CRM_System.Controller;

import com.CRM.Doctor_Patient_CRM_System.Model.Doctor;
import com.CRM.Doctor_Patient_CRM_System.Services.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorServices doctorService;

    @PostMapping
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{doctorId}")
    public Doctor getDoctorById(@PathVariable Long doctorId) {
        return doctorService.getDoctorById(doctorId);
    }

    @PutMapping("/{doctorId}")
    public Doctor updateDoctor(@PathVariable Long doctorId,
                               @RequestBody Doctor doctor) {

        return doctorService.updateDoctor(doctorId, doctor);
    }
    @DeleteMapping("/{doctorId}")
    public String deleteDoctor(@PathVariable Long doctorId) {

        doctorService.deleteDoctor(doctorId);

        return "Doctor Deleted Successfully";
    }
}
