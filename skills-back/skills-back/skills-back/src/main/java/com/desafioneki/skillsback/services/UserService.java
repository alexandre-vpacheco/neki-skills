package com.desafioneki.skillsback.services;

import java.util.List;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioneki.skillsback.entities.User;
import com.desafioneki.skillsback.repositories.UserRepository;

//import java.util.List;
//
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.desafioneki.skillsback.entities.User;
//import com.desafioneki.skillsback.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	//@Autowired
	//private ModelMapper modelMapper;
	
	@Autowired
	public List<User> findAllUsers() {
		List<User> listUsuarios = userRepository.findAll();
		return listUsuarios;
	}
}
