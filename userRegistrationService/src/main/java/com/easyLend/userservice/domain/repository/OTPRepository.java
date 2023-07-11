package com.easyLend.userservice.domain.repository;

import com.easyLend.userservice.domain.entity.AppUser;
import com.easyLend.userservice.domain.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OTPRepository extends JpaRepository<OTP,String> {
    OTP findOTPByUser(String otp, AppUser appUser);
}
