package com.decagon.loanagreementservice.controllers;


import com.decagon.loanagreementservice.models.LoanOffer;
import com.decagon.loanagreementservice.security_config.JwtUtils;
import com.decagon.loanagreementservice.services.BorrowerService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/borrower")
public class BorrowerController {
    private final BorrowerService service;

    @GetMapping("/accept_offer/{offerId}")
    public ResponseEntity<String> selectLoanOffer(@PathVariable("offerId") Long loanId, HttpServletRequest request) {
        // code to select the loan based on the loanId

        service.selectLoanOffer(loanId, request);
        return ResponseEntity.ok("Loan selected successfully");
    }


}
