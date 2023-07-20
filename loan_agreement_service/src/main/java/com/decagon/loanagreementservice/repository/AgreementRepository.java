package com.decagon.loanAgreementSelection.repository;

import com.decagon.loanAgreementSelection.models.LoanAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgreementRepository extends JpaRepository<LoanAgreement, Long> {
    Optional<LoanAgreement> findByLoanId(Long loanId);
}
