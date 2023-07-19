package com.decagon.loanAgreementSelection.services.serviceImpl;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.decagon.loanAgreementSelection.dtos.request.LoanAgreementDto;
import com.decagon.loanAgreementSelection.models.LoanAgreement;
import com.decagon.loanAgreementSelection.models.LoanOffer;
import com.decagon.loanAgreementSelection.models.Status;
import com.decagon.loanAgreementSelection.repository.AgreementRepository;
import com.decagon.loanAgreementSelection.services.ApiClient;
import com.decagon.loanAgreementSelection.services.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BorrowerServiceImpl implements BorrowerService {
    private final ApiClient apiClient;
    private final AgreementRepository repository;
    Random random = new Random();
    long randomLong = random.nextLong(100);
    @Override
    public LoanAgreementDto selectLoanOffer(Long loanId) {
            LoanOffer loanOffer = getLoanOffer(loanId);
            if(Objects.isNull(loanOffer)){
                throw new RuntimeException("loan offer ");
            }
            // todo Set the status of the loan offer to pending. NB the loan application entity is present in a different service
            LoanAgreement loanAgreement = new LoanAgreement();
            loanAgreement.setInterestRate(loanOffer.getInterestRate());
            // todo get the id of the logged in user who in this case is a borrower and replace randomLong.
            loanAgreement.setBorrowerId(randomLong);
            loanAgreement.setLenderId(loanOffer.getLenderId());
            loanAgreement.setStatus(Status.PENDING);
            loanAgreement.setLoanId(loanOffer.getLoanId());
            loanAgreement.setRepaymentSchedule(loanOffer.getRepaymentSchedule());
            repository.save(loanAgreement);
        //            BeanUtils.copyProperties(loanAgreement, loanAgreementDto);
            return new LoanAgreementDto(loanAgreement);
     }




    private LoanOffer getLoanOffer(Long offerId) {
        // todo Use ur FeignClient to call the loanOffer service
        ResponseEntity<LoanOffer> response = apiClient.getLoanOffer(offerId);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle error case
            throw new RuntimeException("Failed to retrieve loan offer.");
        }
    }


    }


