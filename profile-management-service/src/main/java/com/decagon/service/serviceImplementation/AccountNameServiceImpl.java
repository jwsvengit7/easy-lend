package com.decagon.service.serviceImplementation;

import com.decagon.dto.request.AccountNameRequest;
import com.decagon.service.AccountNameService;
import com.decagon.service.NigerianBankService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@Setter
@AllArgsConstructor
public class AccountNameServiceImpl implements ApplicationRunner, AccountNameService {
    private final NigerianBankService nigerianBankService;

    @Override
    public String fetchAccountName(AccountNameRequest request) {
        return nigerianBankService.getAccountName(request);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
