package com.example.transactionservice.service;

import com.example.transactionservice.dto.requests.InitializePaymentRequest;
import com.example.transactionservice.dto.requests.LoanTransactionRequest;
import com.example.transactionservice.dto.response.LoanTransactionResponse;

public interface PaymentService {
    LoanTransactionResponse makePayment(LoanTransactionRequest request);
}
