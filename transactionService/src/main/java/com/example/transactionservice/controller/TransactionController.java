package com.example.transactionservice.controller;

import com.example.transactionservice.dto.requests.LoanTransactionRequest;
import com.example.transactionservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/initialize-payment")
    public ResponseEntity<?> initializeTransaction(@RequestBody LoanTransactionRequest request) {
        return new ResponseEntity<>(transactionService.initializePay(request), HttpStatus.OK);
    }
}
