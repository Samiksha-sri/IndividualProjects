package com.example.Splitwise.commands;

import com.example.Splitwise.controllers.GroupController;
import com.example.Splitwise.dtos.SettleGroupRequestDTO;
import com.example.Splitwise.dtos.SettleGroupResponseDTO;
import com.example.Splitwise.models.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;

@Component
// SettleGroup 10
public class SettleGroupCommand implements Command{

    GroupController groupController;

    @Autowired
    public SettleGroupCommand(GroupController groupController){
        this.groupController = groupController;
    }
    @Override
    public boolean canExecute(String input) {

        if(input.startsWith("SettleGroup") == false){
           return false;
        }

        if(input.split(" ").length != 2){
            return false;
        }

        return true;
    }

    @Override
    public void execute(String input) {

        List<String> parts = Arrays.stream(input.split(" ")).toList();

        Long groupId = Long.parseLong(parts.get(1));

        SettleGroupRequestDTO requestDTO = new SettleGroupRequestDTO();
        requestDTO.setGroupId(groupId);

        SettleGroupResponseDTO responseDTO = groupController.settleGroup(requestDTO);

        for(Transactions transactions : responseDTO.getTransactions()){
            System.out.println("Execute these transactions to settle the group or users");
            System.out.println(transactions.getFrom() + " -> " + transactions.getTo() + " = " + transactions.getAmount());
        }





    }
}
