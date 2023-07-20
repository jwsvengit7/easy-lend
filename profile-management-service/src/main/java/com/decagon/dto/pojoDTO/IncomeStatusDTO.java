package com.decagon.dto.pojoDTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomeStatusDTO {
    private String employmentStatus;
    private String monthlyPersonalIncome;
    private boolean hasOtherSourcesOfIncome;
    private String extraIncomeDescription;
}
