package com.decagon.loanagreementservice.services;

import com.decagon.loanagreementservice.dtos.request.LoanAgreementDto;
import com.decagon.loanagreementservice.models.LoanOffer;
import jakarta.servlet.http.HttpServletRequest;

public interface BorrowerService {
    LoanAgreementDto selectLoanOffer(Long loanId, HttpServletRequest request);
    LoanOffer getLoanOffer(Long offerId);
}
