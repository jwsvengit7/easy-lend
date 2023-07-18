package com.easyLend.userservice.services.serviceImpl;

import com.easyLend.userservice.domain.entity.VerificationEmail;
import com.easyLend.userservice.services.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String findOtp() {
        return null;
    }

    @Override
    public String saveToken(VerificationEmail confirmationToken) {
        return null;
    }
}
