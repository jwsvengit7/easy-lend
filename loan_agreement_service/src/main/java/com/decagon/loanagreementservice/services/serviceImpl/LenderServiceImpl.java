package com.decagon.loanagreementservice.services.serviceImpl;

import com.decagon.loanagreementservice.dtos.request.LoanAgreementDto;
import com.decagon.loanagreementservice.models.LoanAgreement;
import com.decagon.loanagreementservice.repository.AgreementRepository;
import com.decagon.loanagreementservice.services.LenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LenderServiceImpl implements LenderService {
    private final AgreementRepository agreementRepository;

    @Override
    public LoanAgreementDto selectLoanRequest(Long loanId) {
    // todo fetch the loan by the loanId and call the disbursement service
        LoanAgreement loanAgreement = new LoanAgreement();
    return new LoanAgreementDto(loanAgreement);
    }




}
