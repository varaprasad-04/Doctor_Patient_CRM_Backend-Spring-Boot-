package com.CRM.Doctor_Patient_CRM_System.Services;

import com.CRM.Doctor_Patient_CRM_System.Model.Doctor;
import com.CRM.Doctor_Patient_CRM_System.Repositry.DoctorRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServices {
    @Autowired
    private DoctorRepositry doctorRepository;

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    public Doctor getDoctorById(Long doctorId) {

        Optional<Doctor> doctor = doctorRepository.findById(doctorId);

        if (doctor.isPresent()) {
            return doctor.get();
        }

        return null;
    }
    public Doctor updateDoctor(Long doctorId, Doctor doctor) {

        Optional<Doctor> existingDoctor = doctorRepository.findById(doctorId);

        if (existingDoctor.isPresent()) {

            Doctor updateDoctor = existingDoctor.get();

            updateDoctor.setName(doctor.getName());
            updateDoctor.setEmail(doctor.getEmail());
            updateDoctor.setPassword(doctor.getPassword());
            updateDoctor.setPhone(doctor.getPhone());
            updateDoctor.setSpecialization(doctor.getSpecialization());
            updateDoctor.setExperience(doctor.getExperience());
            updateDoctor.setAvailable(doctor.getAvailable());

            return doctorRepository.save(updateDoctor);
        }

        return null;
    }

    public void deleteDoctor(Long doctorId) {

        doctorRepository.deleteById(doctorId);

    }

}
