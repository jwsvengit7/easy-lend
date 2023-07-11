package com.decagon.loanAgreementSelection.controllers;

import com.decagon.loanAgreementSelection.services.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/borrower")
public class BorrowerController {
    private final BorrowerService service;

    @GetMapping("/select")
    public ResponseEntity<String> selectLoan(@RequestParam("loanId") Integer loanId) {
        // Your code to select the loan based on the loanId
        service.selectLoan(loanId);
        return ResponseEntity.ok("Loan selected successfully");
    }

}
