package com.decagon.entity;

import com.decagon.enums.EmploymentStatusType;
import com.decagon.enums.ExtraIncomeType;
import com.decagon.enums.MonthlyIncomeRange;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IncomeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private EmploymentStatusType employmentStatus;
    private MonthlyIncomeRange monthlyPersonalIncome;
    private boolean hasOtherSourcesOfIncome;
    private ExtraIncomeType extraIncomeDescription;
}
