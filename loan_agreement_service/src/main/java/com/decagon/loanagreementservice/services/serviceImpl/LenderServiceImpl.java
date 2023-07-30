package com.decagon.loanagreementservice.services.serviceImpl;

import com.decagon.loanagreementservice.dtos.request.LoanAgreementDto;
import com.decagon.loanagreementservice.exceptions.AgreementNotFoundException;
import com.decagon.loanagreementservice.exceptions.UserNotAuthorizedException;
import com.decagon.loanagreementservice.models.LoanAgreement;
import com.decagon.loanagreementservice.models.Status;
import com.decagon.loanagreementservice.repository.AgreementRepository;
import com.decagon.loanagreementservice.security_config.JwtUtils;
import com.decagon.loanagreementservice.services.LenderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class LenderServiceImpl implements LenderService {
    private final AgreementRepository agreementRepository;

    private final JwtUtils jwtUtils;

    @Override
    public LoanAgreementDto selectLoanRequest(String loanId, HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        String token = auth.substring(7);
        if(!jwtUtils.getUserTypeFromToken(token).equalsIgnoreCase("LENDER")){
            throw  new UserNotAuthorizedException("permission denied");
        }
    LoanAgreement loanAgreement = agreementRepository.findByLoanId(loanId).get();
    if(Objects.isNull(loanAgreement)){
        throw new AgreementNotFoundException("Loan Agreement not found");
    }
        loanAgreement.setStatus(Status.APPROVED);
    // todo use feign client to call the disbursement service

    return new LoanAgreementDto(loanAgreement);
    }



}
