package com.CRM.Doctor_Patient_CRM_System.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
        @Setter
        @Getter
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long patientId;

        @Setter
        @Getter
        private String name;

        @Setter
        @Getter
        private String email;

        @Setter
        @Getter
        private String password;

        @Setter
        @Getter
        private String phone;

        @Setter
        @Getter
        private Integer age;

        @Setter
        @Getter
        private String gender;

        @Setter
        @Getter
        private String bloodGroup;

        @Setter
        @Getter
        private String medicalHistory;

        @OneToMany(mappedBy = "patient")
        private List<Appointment> appointments;

        public Patient() {
        }

        public Patient(Long patientId, String name, String email, String password,
                       String phone, Integer age, String gender,
                       String bloodGroup, String medicalHistory) {
            this.patientId = patientId;
            this.name = name;
            this.email = email;
            this.password = password;
            this.phone = phone;
            this.age = age;
            this.gender = gender;
            this.bloodGroup = bloodGroup;
            this.medicalHistory = medicalHistory;
        }


}
