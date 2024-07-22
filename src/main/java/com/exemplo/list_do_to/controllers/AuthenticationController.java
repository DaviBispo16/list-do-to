package com.exemplo.list_do_to.controllers;

import com.exemplo.list_do_to.exceptions.ExistingUsername;
import com.exemplo.list_do_to.model.user.RegisterDTO;
import com.exemplo.list_do_to.model.user.User;
import com.exemplo.list_do_to.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private ResponseEntity registerUser(@RequestBody @Valid RegisterDTO data) {

        if (this.userRepository.findByUsername(data.username()) != null) {
            throw new ExistingUsername();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        User newUser = new User(data.username(), data.email(), encryptedPassword);

        userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
