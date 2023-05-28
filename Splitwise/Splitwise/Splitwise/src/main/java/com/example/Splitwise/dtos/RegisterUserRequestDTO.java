package com.example.Splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDTO {

    private String name;
    private String phone;
    private String amount;
    private String password;
}
