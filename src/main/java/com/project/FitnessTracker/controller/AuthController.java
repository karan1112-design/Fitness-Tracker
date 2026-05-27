package com.project.FitnessTracker.controller;

import com.project.FitnessTracker.dto.RegisterRequest;
import com.project.FitnessTracker.dto.UserResponse;
import com.project.FitnessTracker.model.User;
import com.project.FitnessTracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;



    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest registerRequest){
        return userService.register(registerRequest);
    }
}
