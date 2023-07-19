package com.decagon.loanAgreementSelection.controllers;

import com.decagon.loanAgreementSelection.services.LenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/lender")
public class LenderController {
    private final LenderService lenderService;

    @GetMapping("/accept_request/{loanId}")
    public ResponseEntity<String> selectLoanRequest(@PathVariable("loanId") Long loanId) {
        // code to select the loan based on the loanId
        lenderService.selectLoanRequest(loanId);
        return ResponseEntity.ok("Loan selected successfully");
    }
}
