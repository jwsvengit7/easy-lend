package com.decagon.loanagreementservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanOffer {
    private Long id;
    private String userId;
    private BigDecimal loanAmount;
    private String loanId;
    private int riskTolerance;
    private BigDecimal interestRate;
    private int durationInDays;

}