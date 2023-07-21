package com.example.transactionservice.service.serviceImpl;

import com.example.transactionservice.dto.requests.InitializePaymentRequest;
import com.example.transactionservice.dto.response.LoanTransactionResponse;
import com.example.transactionservice.service.PaymentService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PayStackPaymentServiceImpl implements PaymentService {
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;
    @Value("${application.paystack.secretKey}")
    String API_SECRET;
    public final static String PAY_STACK_BASE_URL = "https://api.paystack.co";
    @Override
    public LoanTransactionResponse makePayment(InitializePaymentRequest request) {
        //todo: change to feign-client
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set(HttpHeaders.AUTHORIZATION, "Bearer " + API_SECRET);
        HttpEntity<InitializePaymentRequest> requestHttpEntity = new HttpEntity<>(request, header);
        ResponseEntity<String> response = restTemplate.exchange(PAY_STACK_BASE_URL + "/transaction/initialize",
                HttpMethod.POST, requestHttpEntity, String.class);
        LoanTransactionResponse paymentResponse = new LoanTransactionResponse();
        paymentResponse.setStatus(false);
        paymentResponse.setMessage("failed");
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            String jsonResponse = response.getBody();
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
        return  paymentResponse;
    }
}
