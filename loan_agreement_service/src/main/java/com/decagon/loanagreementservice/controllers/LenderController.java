package com.decagon.loanagreementservice.controllers;

import com.decagon.loanagreementservice.services.LenderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/lender")
public class LenderController {
    private final LenderService lenderService;

    @GetMapping("/accept_request/{requestId}")

    public ResponseEntity<String> selectLoanRequest(@PathVariable("requestId") Long loanId, HttpServletRequest request) {
        // code to select the loan based on the loanId
        lenderService.selectLoanRequest(loanId, request);
        return ResponseEntity.ok("Loan selected successfully");
    }
}
