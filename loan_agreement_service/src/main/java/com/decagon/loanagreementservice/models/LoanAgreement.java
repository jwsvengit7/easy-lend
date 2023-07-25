package com.decagon.loanagreementservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.decagon.loanagreementservice.models.Status.NEW;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "loan_Agreement")
    public class LoanAgreement {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "agreement_id")
        private Long agreementId;

        @Column(name = "loan_id")
        private Long loanId;
        @Column(name = "borrower_id")
        private String borrowerId;

        @Column(name = "lender_id")
        private String lenderId;

        @Column(name = "interest")
        private double interestRate;

        @Column(name = "repayment_schedule")
        private String repaymentSchedule;
        @Enumerated(EnumType.STRING)
        private Status status = NEW;

        @Column(name = "conditions")
        private String conditions;

        @Column(name = "created_at")
        @CreationTimestamp
        private LocalDateTime createdAt;

        @Column(name = "updated_at")
        @UpdateTimestamp
        private Timestamp updatedAt;



}
