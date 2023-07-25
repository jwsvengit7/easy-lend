package com.example.transactionservice.service.serviceImpl;

import com.example.transactionservice.dto.requests.InitializePaymentRequest;
import com.example.transactionservice.dto.response.LoanTransactionResponse;
import com.example.transactionservice.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class MockedPaymentServiceImpl implements PaymentService {
    @Override
    public LoanTransactionResponse makePayment(InitializePaymentRequest request) {
        LoanTransactionResponse paymentResponse=new LoanTransactionResponse();
        paymentResponse.setPayStackUrl("http://google.com");
        paymentResponse.setStatus(true);
        paymentResponse.setMessage("successful");
        return paymentResponse;
    }
}
