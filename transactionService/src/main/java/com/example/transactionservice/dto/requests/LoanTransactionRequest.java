package com.example.transactionservice.dto.requests;




public class LoanTransactionRequest {

    private Long loanId;
    private Long borrowerId;

    private Long lenderId;
    private Double amount;
    private String email;
    public LoanTransactionRequest(Long loanId, Long borrowerId, Long lenderId, Double amount, String email) {
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

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Long getLenderId() {
        return lenderId;
    }

    public void setLenderId(Long lenderId) {
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
