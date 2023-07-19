package com.decagon.service;

@FeignClient(name = "user-service", url = "${user-service.url}") // Replace "${user-service.url}" with the actual URL of the User-service
public interface UserServiceFeignClient {

    @GetMapping("/users/{userId}")
    UserDTO getUserById(@PathVariable("userId") Long userId);
}
