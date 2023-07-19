package com.decagon.borrowerservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loanId;

    private int userId;
    @Column(name = "loanAmt", nullable = false)
    private double loanAmt;

    @Column(name = "monthlyEmi", nullable = false)
    private double monthlyEMI;
    @Column(name = "repaymentTerm", nullable = false)
    private int repaymentTerm;
    @Column(name = "purpose", nullable = false)
    private String purpose;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
