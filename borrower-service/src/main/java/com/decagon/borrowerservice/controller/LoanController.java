package com.decagon.borrowerservice.controller;

import com.decagon.borrowerservice.dto.LoanRequestDto;
import com.decagon.borrowerservice.service.BorrowerService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/loanApplication")
public class LoanController {
    @Autowired
    private BorrowerService borrowerService;

    @PostMapping("/apply")
    public ResponseEntity<LoanRequestDto> loanRequest(@RequestBody LoanRequestDto loanRequestDto, HttpServletRequest request) {
        LoanRequestDto savedLoan = borrowerService.loanRequest(loanRequestDto, request);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
    }

}