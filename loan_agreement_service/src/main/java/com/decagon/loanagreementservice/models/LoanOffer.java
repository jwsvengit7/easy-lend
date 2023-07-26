package com.decagon.loanagreementservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanOffer {
    private Long offerId;
    private String lenderId;
    private Long loanId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private double interestRate;
    private String repaymentSchedule;

    // Constructors, getters, and setters
}