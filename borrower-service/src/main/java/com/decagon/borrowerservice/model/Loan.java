package com.decagon.borrowerservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan")

public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loanId;

    private int userId;

    @Column(name = "loanAmt", nullable = false)
    private double loanAmt;

    @Column(name = "monthly_emi", nullable = true)
    private Double monthlyEmi;


    @Column(name = "interestRate", nullable = false)
    private double interestRate;

    @Column(name = "repaymentTerm", nullable = false)
    private int repaymentTerm;

    @Column(name = "totalRepayment", nullable = false)
    private double totalRepayment;

    @Column(name = "purpose", nullable = false)
    private String purpose;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ElementCollection
    @CollectionTable(name = "loan_documents", joinColumns = @JoinColumn(name = "loan_id"))
    private List<String> requiredDocuments = new ArrayList<>();

}