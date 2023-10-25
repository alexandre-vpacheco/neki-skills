package com.desafioneki.skillsback.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafioneki.skillsback.dto.UserDTO;
import com.desafioneki.skillsback.services.UserService;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Map<String, Object>> getUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/users/{id_user}")
    public Map<String, Object> getUserById(@PathVariable int id_user) {
        return userService.getUserById(id_user);
    }
    
    @PostMapping("/users/register")
    public ResponseEntity<String> saveUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO.getUsername(), userDTO.getSenha());
        return new ResponseEntity<>("Usuário cadastrado com sucesso!", HttpStatus.CREATED);
    }
}
