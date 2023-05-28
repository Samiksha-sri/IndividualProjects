package com.example.Splitwise.controllers;

import com.example.Splitwise.dtos.*;
import com.example.Splitwise.dtos.ResponseStatus;
import com.example.Splitwise.models.User;
import com.example.Splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//1. Maven repo
//2. Update POM
//3. Controller to RestController
//4. Post/Get Mapping - depending upon saving/getting info
//5. Retrieve info from HTTP request to make requestDTOs
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/user/register/")
    public RegisterUserResponseDTO registerUser(@RequestBody RegisterUserRequestDTO requestDTO){

        //call service, repo to create the user
        RegisterUserResponseDTO responseDTO = new RegisterUserResponseDTO();

        User user = new User();

        user.setName(requestDTO.getName());
        user.setPhone(requestDTO.getPhone());
        user.setPassword(requestDTO.getPassword());

        try{
            User savedUser =  userService.registerUser(user);
            responseDTO.setUser(user);
            ResponseStatus responseStatus = new ResponseStatus();
            responseStatus.setCode(StatusCode.SUCCESS);
            responseStatus.setMessage("User registered successfully");
            responseDTO.setResponseStatus(responseStatus);

        }catch (Exception e){
            ResponseStatus responseStatus = new ResponseStatus();
            responseStatus.setCode(StatusCode.FAILURE);
            responseStatus.setMessage(e.getMessage());
            responseDTO.setResponseStatus(responseStatus);

        }

        return responseDTO;
    }

    @GetMapping("/user/get/")
    public GetUserResponseDTO getUser(@RequestBody() GetUserRequestDTO requestDTO){

        GetUserResponseDTO responseDTO = new GetUserResponseDTO();

        Long userId = requestDTO.getId();


        try{
            User user =  userService.getUser(userId);
            responseDTO.setUser(user);
            ResponseStatus responseStatus = new ResponseStatus();
            responseStatus.setCode(StatusCode.SUCCESS);
            responseStatus.setMessage("User retrieved successfully");
            responseDTO.setResponseStatus(responseStatus);

        }catch (Exception e){
            ResponseStatus responseStatus = new ResponseStatus();
            responseStatus.setCode(StatusCode.FAILURE);
            responseStatus.setMessage(e.getMessage());
            responseDTO.setResponseStatus(responseStatus);

        }

        return responseDTO;

    }
}
