package com.example.Splitwise.dtos;

import com.example.Splitwise.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponseDTO {

    private User user;
    private ResponseStatus responseStatus;
}
