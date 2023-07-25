package com.example.transactionservice.dto.response;
public class LoanTransactionResponse {
    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static Long serialVersionUID = 2223L;
    private boolean status;
    private String message;
    private String PayStackUrl;
    public LoanTransactionResponse(boolean status, String message, String payStackUrl) {
        this.status = status;
        this.message = message;
        PayStackUrl = payStackUrl;
    }
    public LoanTransactionResponse() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPayStackUrl() {
        return PayStackUrl;
    }

    public void setPayStackUrl(String payStackUrl) {
        PayStackUrl = payStackUrl;
    }


}
