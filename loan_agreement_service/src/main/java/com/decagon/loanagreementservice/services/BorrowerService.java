package com.decagon.loanagreementservice.services;

import com.decagon.loanagreementservice.dtos.request.LoanAgreementDto;

public interface BorrowerService {
    LoanAgreementDto selectLoanOffer(Long loanId);
}
