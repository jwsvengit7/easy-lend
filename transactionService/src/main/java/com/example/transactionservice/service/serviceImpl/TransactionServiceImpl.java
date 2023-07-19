package com.example.transactionservice.service.serviceImpl;

import com.example.transactionservice.dto.requests.InitializePaymentRequest;
import com.example.transactionservice.dto.requests.LoanTransactionRequest;
import com.example.transactionservice.dto.response.LoanTransactionResponse;
import com.example.transactionservice.repositories.TransactionRepository;
import com.example.transactionservice.service.TransactionService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;
    @Value("${application.paystack.secretKey}")
    String API_SECRET;
    public final static String PAY_STACK_BASE_URL = "https://api.paystack.co";

    @Override
    public LoanTransactionResponse initializePay(LoanTransactionRequest request) {
        String reference = UUID.randomUUID().toString().replace("-", "");
        InitializePaymentRequest paymentRequest = new InitializePaymentRequest(
                request.getEmail(), "NGN", String.valueOf(request.getAmount()), reference
        );
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set(HttpHeaders.AUTHORIZATION, "Bearer " + API_SECRET);
        HttpEntity<InitializePaymentRequest> requestHttpEntity = new HttpEntity<>(paymentRequest, header);
        ResponseEntity<String> response = restTemplate.exchange(PAY_STACK_BASE_URL + "/transaction/initialize",
                HttpMethod.POST, requestHttpEntity, String.class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            String jsonResponse = response.getBody();
            LoanTransactionResponse paymentResponse = new LoanTransactionResponse();
            try {
                JsonNode node = objectMapper.readTree(jsonResponse);
                paymentResponse.setPayStackUrl(node.get("data").get("authorization_url").asText());
                paymentResponse.setStatus(true);
                paymentResponse.setMessage("successful");
                return paymentResponse;
            } catch (Exception e) {
                throw new RuntimeException("Error in passing");
            }
        }
        throw new RuntimeException("Failed Transaction");
    }
}

