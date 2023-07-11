package com.decagon.loanAgreementSelection.repository;

import com.decagon.loanAgreementSelection.models.LoanAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanAgreementRepository extends JpaRepository<LoanAgreement, Integer> {
}
