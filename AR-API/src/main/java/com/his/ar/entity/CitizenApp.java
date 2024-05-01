package com.his.ar.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "citizen_app")
public class CitizenApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_num", nullable = false)
    private Integer appNum;

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "ssn")
    private Long ssn;

    @Column(name = "plan_id")
    private Integer planId;

    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDate createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @Column(name = "citizen_id")
    private Integer citizenId;

}