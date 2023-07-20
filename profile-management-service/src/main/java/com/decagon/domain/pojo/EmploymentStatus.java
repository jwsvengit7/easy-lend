package com.decagon.domain.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmploymentStatus {
    private boolean previouslyEmployed;
    private String employmentSituation;
    private double income;
    private String jobType;
}