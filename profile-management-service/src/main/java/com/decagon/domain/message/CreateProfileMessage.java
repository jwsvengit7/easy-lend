package com.decagon.domain.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateProfileMessage {
    private String user_id;
    private String fullName;
    private String email;
}
