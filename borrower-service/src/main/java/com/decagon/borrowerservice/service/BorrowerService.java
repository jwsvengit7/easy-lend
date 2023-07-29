package com.decagon.borrowerservice.service;


import com.decagon.borrowerservice.dto.LoanRequestDto;
import jakarta.servlet.http.HttpServletRequest;

public interface BorrowerService {

//   Loan applyLoan(Loan loan);

    LoanRequestDto loanRequest(LoanRequestDto loanRequestDto, HttpServletRequest request);

}