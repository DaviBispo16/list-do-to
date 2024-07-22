package com.exemplo.list_do_to.controllers;

import com.exemplo.list_do_to.model.user.RegisterDTO;
import com.exemplo.list_do_to.model.user.User;
import com.exemplo.list_do_to.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    private ResponseEntity registerUser(@RequestBody @Valid User data) {
       userRepository.save(data);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
