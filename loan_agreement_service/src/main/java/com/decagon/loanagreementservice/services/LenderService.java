package com.decagon.loanagreementservice.services;

import com.decagon.loanagreementservice.dtos.request.LoanAgreementDto;

public interface LenderService {
    LoanAgreementDto selectLoanRequest(Long loanId);
}