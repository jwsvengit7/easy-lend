package com.decagon.borrowerservice.dto;

import com.decagon.borrowerservice.model.Loan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {

    private Long loanId;

    private double loanAmt;

    private Double monthlyEmi;

    private double interestRate;

    private int repaymentTerm;

    private double totalRepayment;

    private String purpose;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<String> requiredDocuments = new ArrayList<>();

    public LoanDto(Loan loan) {
        this.loanId = loan.getLoanId();
        this.loanAmt = loan.getLoanAmt();
        this.monthlyEmi = loan.getMonthlyEmi();
        this.interestRate = loan.getInterestRate();
        this.repaymentTerm = loan.getRepaymentTerm();
        this.totalRepayment = loan.getTotalRepayment();
        this.purpose = loan.getPurpose();
        this.createdAt = loan.getCreatedAt();
        this.updatedAt = loan.getUpdatedAt();
        this.requiredDocuments = loan.getRequiredDocuments();
    }
}
