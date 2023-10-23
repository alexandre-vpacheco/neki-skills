package com.desafioneki.skillsback.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioneki.skillsback.dto.UserResumidoDTO;

import com.desafioneki.skillsback.entities.User;
import com.desafioneki.skillsback.repositories.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public User getUserById(Integer id_user) {
        return userRepository.findById(id_user).orElse(null);
    }
	
	public List<UserResumidoDTO> findAllUsers() {
		List<User> listUsuarios = userRepository.findAll();
		List<UserResumidoDTO> listUsuDTO = modelMapper.map(listUsuarios, new TypeToken<List<UserResumidoDTO>>(){}.getType());		
//		List<UsuarioDTO> listUsuDTO = Arrays.asList(modelMapper.map(listUsuarios, UsuarioDTO[].class));
		return listUsuDTO;
	}
}
