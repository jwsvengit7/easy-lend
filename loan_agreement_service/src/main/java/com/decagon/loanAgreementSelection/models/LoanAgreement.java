package com.decagon.loanAgreementSelection.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "LoanAgreement")
    public class LoanAgreement {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "agreement_id")
        private Integer agreementId;

        @Column(name = "loan_id")
        private Integer loanId;

        @Column(name = "borrower_id")
        private Integer borrowerId;

        @Column(name = "lender_id")
        private Integer lenderId;

        @Column(name = "interest_rate")
        private BigDecimal interestRate;

        @Column(name = "repayment_schedule")
        private String repaymentSchedule;

        @Column(name = "conditions")
        private String conditions;

        @Column(name = "created_at")
        private Timestamp createdAt;

        @Column(name = "updated_at")
        private Timestamp updatedAt;



}
