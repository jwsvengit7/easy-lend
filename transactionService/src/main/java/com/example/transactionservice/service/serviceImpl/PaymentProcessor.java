package com.example.transactionservice.service.serviceImpl;

import com.example.transactionservice.service.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class PaymentProcessor {
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;
    public PaymentService getProcessor(PaymentChoice paymentChoice){
        switch (paymentChoice){
            case GO_TO_PAYSTACK -> {
                return new PayStackPaymentServiceImpl(objectMapper,restTemplate);
            }
            case MOCKED -> {
                return new MockedPaymentServiceImpl();
            }
            default -> {
                return new PayStackPaymentServiceImpl(objectMapper,restTemplate);
            }
        }
    }
}
