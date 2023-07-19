package com.decagon.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDetails {
    private Long user_id;
    private String fullName;
    private String email;
    private String phoneNumber;
}
