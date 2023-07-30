package com.decagon.loanagreementservice.dtos.request;

import com.decagon.loanagreementservice.models.LoanAgreement;
import com.decagon.loanagreementservice.models.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static com.decagon.loanagreementservice.models.Status.NEW;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanAgreementDto {

    private Long agreementId;


    private String loanId;

    private String borrowerId;


    private String lenderId;


    private BigDecimal interestRate;


    private int durationInDays;
    @Enumerated(EnumType.STRING)
    private Status status = NEW;


    private String conditions;
    public LoanAgreementDto(LoanAgreement loanAgreement) {
        this.loanId = loanAgreement.getLoanId();
        this.borrowerId = loanAgreement.getBorrowerId();
        this.lenderId = loanAgreement.getLenderId();
        this.interestRate = loanAgreement.getInterestRate();
        this.durationInDays = loanAgreement.getDurationInDays();
        this.status = loanAgreement.getStatus();
        this.conditions = conditions;
    }
}