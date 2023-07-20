package com.decagon.loanAgreementSelection.dtos.request;

import com.decagon.loanAgreementSelection.models.LoanAgreement;
import com.decagon.loanAgreementSelection.models.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import static com.decagon.loanAgreementSelection.models.Status.NEW;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanAgreementDto {

    private Long agreementId;


    private Long loanId;
    @Column(name = "borrower_id")
    private Long borrowerId;

    @Column(name = "lender_id")
    private Long lenderId;

    @Column(name = "interest")
    private double interestRate;

    @Column(name = "repayment_schedule")
    private String repaymentSchedule;
    @Enumerated(EnumType.STRING)
    private Status status = NEW;

    @Column(name = "conditions")
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


