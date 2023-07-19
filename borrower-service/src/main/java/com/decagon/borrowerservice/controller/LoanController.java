package com.decagon.borrowerservice.controller;

import com.decagon.borrowerservice.dto.LoanDto;
import com.decagon.borrowerservice.model.Loan;
import com.decagon.borrowerservice.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/loan")
public class LoanController {

    private LoanService loanService;

    @PostMapping("/apply")
    public ResponseEntity<LoanDto> loanRequest(@RequestBody LoanDto loanDto) {
        LoanDto savedLoan = loanService.loanRequest(loanDto);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
    }
}