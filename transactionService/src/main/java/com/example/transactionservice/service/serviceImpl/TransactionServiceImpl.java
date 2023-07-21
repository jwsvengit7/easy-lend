package com.example.transactionservice.service.serviceImpl;

import com.example.transactionservice.dto.requests.InitializePaymentRequest;
import com.example.transactionservice.dto.requests.LoanTransactionRequest;
import com.example.transactionservice.dto.response.LoanTransactionResponse;
import com.example.transactionservice.repositories.TransactionRepository;
import com.example.transactionservice.service.PaymentService;
import com.example.transactionservice.service.TransactionService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final PaymentProcessor paymentProcessor;

    @Override
    public LoanTransactionResponse initializePay(LoanTransactionRequest request) {
        if(StringUtils.isBlank(request.getLenderId()) && StringUtils.isBlank(request.getBorrowerId())){

        }
        String reference = UUID.randomUUID().toString().replace("-", "");
        InitializePaymentRequest paymentRequest = new InitializePaymentRequest(
                request.getEmail(), "NGN", String.valueOf(request.getAmount()), reference
        );
        PaymentService paymentService=paymentProcessor.getProcessor(PaymentChoice.GO_TO_PAYSTACK);
        return paymentService.makePayment(paymentRequest);
    }
}

