package com.desafioneki.skillsback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafioneki.skillsback.dto.LoginRequest;
import com.desafioneki.skillsback.services.AuthenticationService;

@RestController
public class AuthController {
	
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String senha = loginRequest.getSenha();

        if (authenticationService.authenticateUser(username, senha)) {
            return new ResponseEntity<>("Login bem sucedido!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login falhou!", HttpStatus.UNAUTHORIZED);
        }
    }
	
}
