package com.decagon.borrowerservice.repository;

import com.decagon.borrowerservice.dto.LoanDto;
import com.decagon.borrowerservice.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}