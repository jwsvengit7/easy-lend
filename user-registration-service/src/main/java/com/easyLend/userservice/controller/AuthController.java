package com.easyLend.userservice.controller;

import com.easyLend.userservice.domain.constant.UserType;
import com.easyLend.userservice.request.RegisterRequest;
import com.easyLend.userservice.response.ApiResponse;
import com.easyLend.userservice.response.RegisterResponse;
import com.easyLend.userservice.services.AppUserService;
import com.easyLend.userservice.services.OTPService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {
    private final AppUserService appUserService;
    private final OTPService otpService;
    @PostMapping("/register/{usertype}")
    public ResponseEntity<ApiResponse<RegisterResponse>> registerUser (@RequestBody RegisterRequest registerRequest,
                                                                       @PathVariable UserType usertype, HttpServletRequest request) {
        ApiResponse<RegisterResponse> apiResponse = new ApiResponse<>(appUserService.registerUser(registerRequest, usertype, request));
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }



}
