package com.decagon.loanagreementservice.services.serviceImpl;

import com.decagon.loanagreementservice.dtos.request.LoanAgreementDto;
import com.decagon.loanagreementservice.models.LoanAgreement;
import com.decagon.loanagreementservice.models.LoanOffer;
import com.decagon.loanagreementservice.models.Status;
import com.decagon.loanagreementservice.repository.AgreementRepository;
import com.decagon.loanagreementservice.services.LoanOfferClient;
import com.decagon.loanagreementservice.services.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class BorrowerServiceImpl implements BorrowerService {
    private final LoanOfferClient loanOfferClient;
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
        //fei
        ResponseEntity<LoanOffer> response = loanOfferClient.getLoanOffer(offerId);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle error case
            throw new RuntimeException("Failed to retrieve loan offer.");
        }
    }


    }


