package com.decagon.lendingservice.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "loan")
public class Loan implements Serializable {

    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loan_id;

    //user id will be mapped here

    @Column(name = "loan_amount")
    private BigDecimal loanAmount;

    @Column
    private String purpose;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "repayment_terms")
    private int repaymentTerms;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Loan() {
    }

    public Loan(String userId, BigDecimal loanAmount, String purpose, BigDecimal interestRate,
                int repaymentTerms, LocalDateTime createdAt, LocalDateTime updatedAt) {
//        this.userId = generateUserId();
        this.loanAmount = loanAmount;
        this.purpose = purpose;
        this.interestRate = interestRate;
        this.repaymentTerms = repaymentTerms;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private String generateUserId() {
        return UUID.randomUUID().toString();
    }
}
