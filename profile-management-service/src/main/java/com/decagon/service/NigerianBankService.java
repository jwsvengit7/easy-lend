package com.decagon.service;

import com.decagon.dto.request.AccountNameRequest;

import java.util.List;

public interface NigerianBankService {
    List<String> getNigerianBanks();
    String getAccountName(AccountNameRequest request);
}
