package com.decagon.dto.pojoDTO;

import com.decagon.domain.pojo.BankAccount;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccountDTO {
    private String bank;
    private String accountNumber;
    private String accountName;

    public BankAccountDTO(BankAccount bankAccount) {
        this.bank = bankAccount.getBank();
        this.accountNumber = bankAccount.getAccountNumber();
        this.accountName = bankAccount.getAccountName();
    }
}
