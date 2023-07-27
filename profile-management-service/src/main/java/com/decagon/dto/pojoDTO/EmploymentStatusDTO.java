package com.decagon.dto.pojoDTO;

import com.decagon.domain.pojo.EmploymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmploymentStatusDTO {
    private boolean previouslyEmployed;
    private String employmentSituation;
    private double income;
    private String jobType;

    public EmploymentStatusDTO(EmploymentStatus employmentStatus) {
        this.previouslyEmployed = employmentStatus.isPreviouslyEmployed();
        this.employmentSituation = employmentStatus.getEmploymentSituation();
        this.income = employmentStatus.getIncome();
        this.jobType = employmentStatus.getJobType();
    }
}
