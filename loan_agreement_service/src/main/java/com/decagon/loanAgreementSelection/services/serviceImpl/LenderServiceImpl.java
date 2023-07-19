package com.decagon.loanAgreementSelection.services.serviceImpl;

import com.decagon.loanAgreementSelection.dtos.request.LoanAgreementDto;
import com.decagon.loanAgreementSelection.models.LoanAgreement;
import com.decagon.loanAgreementSelection.repository.AgreementRepository;
import com.decagon.loanAgreementSelection.services.LenderService;
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
