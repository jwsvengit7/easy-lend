package com.decagon.service.serviceImplementation;

import com.decagon.dto.request.AccountNameRequest;
import com.decagon.service.AccountNameService;
import com.decagon.service.NigerianBankService;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class AccountNameServiceImpl implements AccountNameService {
    private final NigerianBankService nigerianBankService;

    @Override
    public String fetchAccountName(AccountNameRequest request) {
        return nigerianBankService.getAccountName(request);
    }
}
