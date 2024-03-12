package com.minura.recipe.controller;

import com.minura.recipe.dto.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("users")
    public UserEntity createUser(@RequestBody UserEntity user){
        return user;
    }
}
