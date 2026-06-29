package com.CRM.Doctor_Patient_CRM_System.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

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
    private String specialization;

    @Setter
    @Getter
    private Integer experience;

    @Getter
    @Setter
    private Boolean available;


    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}
