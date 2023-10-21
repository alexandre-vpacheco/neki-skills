package com.desafioneki.skillsback.controllers;

import java.util.List;

//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioneki.skillsback.entities.User;
import com.desafioneki.skillsback.services.UserService;


@RestController
@RequestMapping("/skills")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	@GetMapping("/users")
	public ResponseEntity<List<User>> findAllUsers() {
		return new ResponseEntity<>(userService.findAllUsers(),
				HttpStatus.OK);
	}
}
