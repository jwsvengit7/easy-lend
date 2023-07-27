package com.decagon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserObject {
    //{"userId":"dbb850ed-ec22-4239-bf25-c6310362901a","fullName":"John Doe","email":"john@example.com"}
    String userId;
    String fullName;
    String email;
}
