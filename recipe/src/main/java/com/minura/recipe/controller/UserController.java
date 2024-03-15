package com.minura.recipe.controller;

import com.minura.recipe.model.User;
import com.minura.recipe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
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

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        System.out.println(optionalUser);
        if (optionalUser.isPresent()){
            userRepository.delete(optionalUser.get());
            return "User with id "+userId+" is deleted";
        }
        return "Invalid userId";
    }
}
