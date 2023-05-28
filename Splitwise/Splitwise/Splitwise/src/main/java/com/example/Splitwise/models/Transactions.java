package com.example.Splitwise.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transactions {

    private String from;
    private String to;
    private int amount;
}
