package com.decagon.lendingservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "investment_preference")
public class  InvestmentPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int preference_id;
    @Column(name = "loan_amount")
    private BigDecimal loanAmount;
    @Column(name = "interest_rate")
    private BigDecimal interestRate;
    @Column(name = "risk_tolerance")
    private int riskTolerance;
    @Column(name = "duration_in_days")
    private int durationInDays;

//    public InvestmentPreference() {
//    }
//
//    public InvestmentPreference(BigDecimal loanAmount, BigDecimal interestRate, int riskTolerance, int durationInDays) {
//        this.loanAmount = loanAmount;
//        this.interestRate = interestRate;
//        this.riskTolerance = riskTolerance;
//        this.durationInDays = durationInDays;
//    }
}
