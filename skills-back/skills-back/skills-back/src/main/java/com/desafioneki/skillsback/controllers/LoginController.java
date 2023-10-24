package com.desafioneki.skillsback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioneki.skillsback.entities.LoginRequest;
import com.desafioneki.skillsback.entities.User;
import com.desafioneki.skillsback.repositories.UserRepository;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Integer> login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByUsernameAndSenha(loginRequest.getUsername(), loginRequest.getSenha());

        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(200);
        } else {
            return ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

	private ResponseEntity<Integer> ResponseEntity(HttpStatus unauthorized) {
		
		return null;
	}
}
