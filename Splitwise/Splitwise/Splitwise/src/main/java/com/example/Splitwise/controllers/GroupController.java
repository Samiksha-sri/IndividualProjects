package com.example.Splitwise.controllers;

import com.example.Splitwise.dtos.ResponseStatus;
import com.example.Splitwise.dtos.SettleGroupRequestDTO;
import com.example.Splitwise.dtos.SettleGroupResponseDTO;
import com.example.Splitwise.dtos.StatusCode;
import com.example.Splitwise.models.Transactions;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupController {

    public SettleGroupResponseDTO settleGroup(SettleGroupRequestDTO requestDTO){
        Long groupId = requestDTO.getGroupId();

        SettleGroupResponseDTO responseDTO = new SettleGroupResponseDTO();

        ResponseStatus responseStatus = new ResponseStatus();

        responseStatus.setCode(StatusCode.SUCCESS);
        responseStatus.setMessage("Group Settlement transactions retrieved successfully.");

        responseDTO.setResponseStatus(responseStatus);

        List<Transactions> transactionsList = new ArrayList<>();

        Transactions t1 = new Transactions();

        t1.setFrom("A");
        t1.setTo("B");
        t1.setAmount(10);

        transactionsList.add(t1);

        Transactions t2 = new Transactions();

        t2.setFrom("B");
        t2.setTo("C");
        t2.setAmount(20);

        transactionsList.add(t2);

        responseDTO.setTransactions(transactionsList);

        return responseDTO;


    }
}
