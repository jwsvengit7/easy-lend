package com.decagon.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountNameRequest {
    private String bank;
    private String accountNumber;
}
