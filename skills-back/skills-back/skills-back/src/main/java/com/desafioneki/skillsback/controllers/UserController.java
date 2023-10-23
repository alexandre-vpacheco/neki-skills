package com.desafioneki.skillsback.controllers;

import java.util.List;
import java.util.Optional;

//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioneki.skillsback.dto.UserResumidoDTO;
import com.desafioneki.skillsback.entities.User;
import com.desafioneki.skillsback.repositories.UserRepository;
import com.desafioneki.skillsback.services.UserRegistrationRequest;
import com.desafioneki.skillsback.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	@GetMapping
	public ResponseEntity<List<UserResumidoDTO>> findAllUsers() {
		return new ResponseEntity<>(userService.findAllUsers(),
				HttpStatus.OK);
	}
	
    @GetMapping("/{id_user}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id_user) {
        Optional<User> user = userRepository.findById(id_user);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        if (registrationRequest == null || registrationRequest.getUsername() == null || registrationRequest.getSenha() == null) {
            return ResponseEntity.badRequest().body("Forneça o nome de usuário e a senha");
        }

        // Cria um novo usuário.
        User user = userService.createUser(registrationRequest.getUsername(), registrationRequest.getSenha());

        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }
}
