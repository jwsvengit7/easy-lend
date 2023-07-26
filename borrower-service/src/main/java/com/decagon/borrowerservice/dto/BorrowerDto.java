package com.decagon.borrowerservice.dto;

import com.decagon.borrowerservice.entities.Borrower;
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
public class BorrowerDto {
    private double loanAmt;

    private Double monthlyEmi;

    private double interestRate;

    private int repaymentTerm;

    private double totalRepayment;

    private String purpose;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<String> requiredDocuments = new ArrayList<>();

    public BorrowerDto(Borrower borrower) {
        this.loanAmt = borrower.getLoanAmt();
        this.monthlyEmi = borrower.getMonthlyEmi();
        this.interestRate = borrower.getInterestRate();
        this.repaymentTerm = borrower.getRepaymentTerm();
        this.totalRepayment = borrower.getTotalRepayment();
        this.purpose = borrower.getPurpose();
        this.createdAt = borrower.getCreatedAt();
        this.updatedAt = borrower.getUpdatedAt();
        this.requiredDocuments = borrower.getRequiredDocuments();
    }
}
