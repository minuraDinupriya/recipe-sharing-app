package com.minura.recipe.controller;

import com.minura.recipe.model.User;
import com.minura.recipe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;//
    @PostMapping("users")
    public String createUser(@RequestBody User user)    {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        System.out.println(optionalUser);
        if (optionalUser.isPresent()){
            return "User with email "+user.getEmail()+" already exists";
        }
        userRepository.save(user);
        return "User saved successfully";
    }
}
