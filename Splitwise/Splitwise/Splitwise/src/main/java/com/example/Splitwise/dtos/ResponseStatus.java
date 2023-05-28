package com.example.Splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStatus {

    private StatusCode code;
    private String message;

}
