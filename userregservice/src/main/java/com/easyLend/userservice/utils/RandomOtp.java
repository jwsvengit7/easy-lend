package com.easyLend.userservice.utils;

import java.util.UUID;

public class RandomOtp {

    public static String otpGererator(){
        UUID otp = UUID.randomUUID();
        String generateOtp = otp.toString().substring(0,4);
        return generateOtp;
    }
}
