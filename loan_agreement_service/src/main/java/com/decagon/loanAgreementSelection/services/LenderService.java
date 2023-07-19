package com.decagon.loanAgreementSelection.services;

import com.decagon.loanAgreementSelection.dtos.request.LoanAgreementDto;

public interface LenderService {
    LoanAgreementDto selectLoanRequest(Long loanId);
}
