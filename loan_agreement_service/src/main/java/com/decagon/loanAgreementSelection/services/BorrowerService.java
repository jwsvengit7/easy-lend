package com.decagon.loanAgreementSelection.services;

import com.decagon.loanAgreementSelection.dtos.request.LoanAgreementDto;

public interface BorrowerService {
    LoanAgreementDto selectLoanOffer(Long loanId);
}
