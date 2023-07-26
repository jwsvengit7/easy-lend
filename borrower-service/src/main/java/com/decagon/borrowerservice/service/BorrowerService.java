package com.decagon.borrowerservice.service;


import com.decagon.borrowerservice.dto.BorrowerDto;

public interface BorrowerService {

//   Loan applyLoan(Loan loan);

    BorrowerDto loanRequest(BorrowerDto borrowerDto);

}