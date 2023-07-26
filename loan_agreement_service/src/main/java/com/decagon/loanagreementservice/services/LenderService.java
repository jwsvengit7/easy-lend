package com.decagon.loanagreementservice.services;

import com.decagon.loanagreementservice.dtos.request.LoanAgreementDto;
import jakarta.servlet.http.HttpServletRequest;

public interface LenderService {

    LoanAgreementDto selectLoanRequest(Long loanId, HttpServletRequest request);
}
