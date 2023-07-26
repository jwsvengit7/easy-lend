package com.decagon.loanagreementservice.dtos.request;

import com.decagon.loanagreementservice.models.LoanAgreement;
import com.decagon.loanagreementservice.models.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.decagon.loanagreementservice.models.Status.NEW;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanAgreementDto {

    private Long agreementId;


    private Long loanId;

    private String borrowerId;


    private String lenderId;


    private double interestRate;


    private String repaymentSchedule;
    @Enumerated(EnumType.STRING)
    private Status status = NEW;


    private String conditions;
    public LoanAgreementDto(LoanAgreement loanAgreement) {
        this.loanId = loanAgreement.getLoanId();
        this.borrowerId = loanAgreement.getBorrowerId();
        this.lenderId = loanAgreement.getLenderId();
        this.interestRate = loanAgreement.getInterestRate();
        this.repaymentSchedule = loanAgreement.getRepaymentSchedule();
        this.status = loanAgreement.getStatus();
        this.conditions = conditions;
    }
}


