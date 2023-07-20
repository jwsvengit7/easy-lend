package com.easyLend.userservice.controller;
import com.easyLend.userservice.domain.entity.UserProfile;
import com.easyLend.userservice.response.ApiResponse;
import com.easyLend.userservice.services.AppUserService;
import com.easyLend.userservice.services.serviceImpl.AppUserServiceImpl;
import com.easyLend.userservice.services.serviceImpl.RabbitMQSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/mq")
@RequiredArgsConstructor
public class RabbitMQController {
    private final RabbitMQSender rabbitMQSender;
    private final AppUserService appUserService;

    @PostMapping(value = "/sender")
    public ResponseEntity<ApiResponse<?>> sendProfile(@RequestBody UserProfile userProfile) {
        rabbitMQSender.send(userProfile);
        ApiResponse<?> apiResponse = new ApiResponse<>("message sent to queue");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
