package com.example.Splitwise.commands;

import com.example.Splitwise.dtos.RegisterUserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRegistry {

    private List<Command> registeredCommands = new ArrayList<>();

    @Autowired
    public CommandRegistry(RegisterUserCommand registerUserCommand, SettleGroupCommand settleGroupCommand){
        registeredCommands.add(registerUserCommand);
        registeredCommands.add(settleGroupCommand);
    }

    public void execute(String input){
        for(Command registeredCommand : registeredCommands){
            if(registeredCommand.canExecute(input)){
                registeredCommand.execute(input);
                break;
            }
        }
    }
}
