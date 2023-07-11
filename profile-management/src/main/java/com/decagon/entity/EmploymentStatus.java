package com.decagon.entity;

import com.decagon.enums.EmploymentSituation;
import com.decagon.enums.JobType;
import jakarta.persistence.*;

@Entity
@Table(name = "employment_status")
public class EmploymentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean previouslyEmployed;
    private EmploymentSituation employmentSituation;
    private double income;
    private JobType jobType;
}