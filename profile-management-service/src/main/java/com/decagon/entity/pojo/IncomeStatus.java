package com.decagon.entity.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomeStatus {
    private String employmentStatus;
    private String monthlyPersonalIncome;
    private boolean hasOtherSourcesOfIncome;
    private String extraIncomeDescription;
}
