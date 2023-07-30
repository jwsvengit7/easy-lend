package com.example.transactionservice.service.serviceImpl;

import com.example.transactionservice.dto.requests.LoanTransactionRequest;
import com.example.transactionservice.dto.response.LoanTransactionResponse;
import com.example.transactionservice.entities.Transactions;
import com.example.transactionservice.repositories.TransactionRepository;
import com.example.transactionservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

import static com.example.transactionservice.enums.PaymentChoice.FLUTTERWAVE;
import static com.example.transactionservice.enums.PaymentChoice.MOCKED;
@Service
@RequiredArgsConstructor
public class FlutterwaveServiceImpl implements PaymentService {

    private final TransactionRepository transactionRepository;
    @Override
    public LoanTransactionResponse makePayment(LoanTransactionRequest request) {
        Transactions transactions = new Transactions();
        String transactionId = UUID.randomUUID().toString().replace("-","").substring(9);
        if(Objects.isNull(request)){
            //TODO Controller Adviser
            throw new RuntimeException();

        }
        transactions.setLoanId(request.getLoanId());
        transactions.setAmount(request.getAmount());
        transactions.setBorrowId(request.getBorrowerId());
        transactions.setPaymentChoice(FLUTTERWAVE);
        transactions.setTransactionId(transactionId);
        LoanTransactionResponse paymentResponse=new LoanTransactionResponse();
        Transactions savedTransaction = transactionRepository.save(transactions);
        paymentResponse.setStatus(true);
        paymentResponse.setMessage("successful");
        paymentResponse.setData(savedTransaction);
        return paymentResponse;
    }
}
