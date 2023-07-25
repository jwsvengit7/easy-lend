package com.example.transactionservice.dto.requests;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanTransactionRequest {

    @JsonProperty("loanId")
    private Long loanId;
    @JsonProperty("borrowerId")

    private String borrowerId;
    @JsonProperty("lenderId")
    private String lenderId;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("email")
    private String email;

    public LoanTransactionRequest(Long loanId, String borrowerId, String lenderId, Double amount, String email) {
        this.loanId = loanId;
        this.borrowerId = borrowerId;
        this.lenderId = lenderId;
        this.amount = amount;
        this.email = email;
    }

    public LoanTransactionRequest() {
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getLenderId() {
        return lenderId;
    }

    public void setLenderId(String lenderId) {
        this.lenderId = lenderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
