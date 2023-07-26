package com.decagon.borrowerservice.controller;

import com.decagon.borrowerservice.dto.BorrowerDto;
import com.decagon.borrowerservice.service.BorrowerService;
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
    public ResponseEntity<BorrowerDto> loanRequest(@RequestBody BorrowerDto borrowerDto) {
        BorrowerDto savedLoan = borrowerService.loanRequest(borrowerDto);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
    }
}