package com.decagon.loanagreementservice.controllers;

import com.decagon.loanagreementservice.services.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/borrower")
public class BorrowerController {
    private final BorrowerService service;

    @GetMapping("/accept_offer/{offerId}")
    public ResponseEntity<String> selectLoanOffer(@PathVariable("offerId") Long loanId) {
        // code to select the loan based on the loanId
        service.selectLoanOffer(loanId);
        return ResponseEntity.ok("Loan selected successfully");
    }

}
