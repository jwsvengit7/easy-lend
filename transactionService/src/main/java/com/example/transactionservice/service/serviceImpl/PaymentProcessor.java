package com.example.transactionservice.service.serviceImpl;

import com.example.transactionservice.enums.PaymentChoice;
import com.example.transactionservice.repositories.TransactionRepository;
import com.example.transactionservice.service.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class PaymentProcessor {
    private final TransactionRepository transactionRepository;

    public PaymentService getProcessor(String paymentChoice){
        switch (paymentChoice){
            case "PAYSTACK" -> {
                System.out.println("new paystack");
                return new PayStackPaymentServiceImpl(transactionRepository);
            }
            case "MOCKED" -> {
                return new MockedPaymentServiceImpl(transactionRepository);
            }
            case "FLUTTERWAVE" -> {
                return new MockedPaymentServiceImpl(transactionRepository);
            }
            default -> {
                return new PayStackPaymentServiceImpl(transactionRepository);
            }
        }
    }
}
