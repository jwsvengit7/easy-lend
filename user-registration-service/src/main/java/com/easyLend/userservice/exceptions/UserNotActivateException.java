package com.easyLend.userservice.exceptions;

public class UserNotActivateException extends RuntimeException{

    public UserNotActivateException(String message){
        super(message);
    }
}
