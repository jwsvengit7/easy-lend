package com.decagon.service;

import com.decagon.dto.request.AccountNameRequest;

public interface AccountNameService {
    String fetchAccountName(AccountNameRequest request);
}
