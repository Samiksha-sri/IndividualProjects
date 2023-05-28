package com.example.Splitwise.commands;

import com.example.Splitwise.controllers.UserController;
import com.example.Splitwise.dtos.RegisterUserRequestDTO;
import com.example.Splitwise.dtos.RegisterUserResponseDTO;
import com.example.Splitwise.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Component
//RegisterUser "A" "9999993193" "xyz" - Input
public class RegisterUserCommand implements  Command{

    private UserController userController;

    private RegisterUserCommand(UserController userController){
        this.userController = userController;
    }
    @Override
    public boolean canExecute(String input) {
        if(input.startsWith("RegisterUser") == false){
            return false;
        }else if(input.split(" ").length != 4){
            return false;
        }
        return true;
    }

    @Override
    public void execute(String input) {

        List<String> params = Arrays.stream(input.split(" ")).toList();

        String name = params.get(1);
        String phone = params.get(2);
        String password = params.get(3);

        RegisterUserRequestDTO requestDTO = new RegisterUserRequestDTO();
        requestDTO.setName(name);
        requestDTO.setPhone(phone);
        requestDTO.setPassword(password);

        RegisterUserResponseDTO responseDTO = userController.registerUser(requestDTO);
        User savedUser = responseDTO.getUser();
        System.out.println(savedUser.getId() + " is the id of new user");

    }
}
