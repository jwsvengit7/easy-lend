package com.decagon.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Request {
    private String name;
    private String email;
    private int age;
}
