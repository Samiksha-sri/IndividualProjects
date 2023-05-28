package com.example.Splitwise.dtos;

import com.example.Splitwise.models.Transactions;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleGroupResponseDTO {

   private List<Transactions> transactions;
   private ResponseStatus responseStatus;

}
