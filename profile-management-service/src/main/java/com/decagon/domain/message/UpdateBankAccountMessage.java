package com.decagon.domain.message;

import com.decagon.dto.pojoDTO.BankAccountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateBankAccountMessage {
    private Long profileId;
    private BankAccountDTO bankAccountDTO;
}
