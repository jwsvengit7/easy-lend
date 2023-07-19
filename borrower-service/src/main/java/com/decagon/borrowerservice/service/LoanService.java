package com.decagon.borrowerservice.service;


import com.decagon.borrowerservice.dto.LoanDto;
import com.decagon.borrowerservice.model.Loan;

public interface LoanService {

//   Loan applyLoan(Loan loan);

    LoanDto loanRequest(LoanDto loanDto);

}