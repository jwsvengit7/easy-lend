package com.decagon.dto.pojoDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmploymentStatusDTO {
    private boolean previouslyEmployed;
    private String employmentSituation;
    private double income;
    private String jobType;
}
