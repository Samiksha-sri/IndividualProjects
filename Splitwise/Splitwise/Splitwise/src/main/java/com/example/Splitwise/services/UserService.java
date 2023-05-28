package com.example.Splitwise.services;

import com.example.Splitwise.controllers.UserController;
import com.example.Splitwise.models.User;
import com.example.Splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User getUser(Long userId) throws Exception {
        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty()){
            throw new Exception("User not found");
        }
        else{
            return user.get();
        }
    }
}
