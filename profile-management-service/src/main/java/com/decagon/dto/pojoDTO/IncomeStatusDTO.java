package com.decagon.dto.pojoDTO;


import com.decagon.domain.pojo.IncomeStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomeStatusDTO {
    private String employmentStatus;
    private String monthlyPersonalIncome;
    private boolean hasOtherSourcesOfIncome;
    private String extraIncomeDescription;

    public IncomeStatusDTO(IncomeStatus status) {
        this.employmentStatus = status.getEmploymentStatus();
        this.monthlyPersonalIncome = status.getMonthlyPersonalIncome();
        this.hasOtherSourcesOfIncome = status.isHasOtherSourcesOfIncome();
        this.extraIncomeDescription = status.getExtraIncomeDescription();
    }
}
