package com.easyLend.userservice.request;

import com.easyLend.userservice.domain.constant.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegisterRequest {
    private String email;
    private String fullName;
    private UserType userType;
    private String password;


}
