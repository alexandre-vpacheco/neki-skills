package com.desafioneki.skillsback.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioneki.skillsback.dto.UserResumidoDTO;
import com.desafioneki.skillsback.entities.User;
import com.desafioneki.skillsback.exceptions.UsernameAlreadyExistsException;
import com.desafioneki.skillsback.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<UserResumidoDTO> findAllUsers() {
		List<User> listUsuarios = userRepository.findAll();
		List<UserResumidoDTO> listUsuDTO = modelMapper.map(listUsuarios, new TypeToken<List<UserResumidoDTO>>() {
		}.getType());
		return listUsuDTO;
	}

	public User getUserById(Integer id_user) {
		return userRepository.findById(id_user).orElse(null);
	}
	
	   public User createUser(String username, String senha) {
	        // Verifica se o nome de usuário já existe.
	        if (userRepository.findByUsername(username) != null) {
	            throw new UsernameAlreadyExistsException("Nome de usuário já está em uso");
	        }

	        // Cria uma instância de User.
	        User user = new User();
	        user.setUsername(username);
	        // Senha sem criptografia.
	        user.setSenha(senha);

	        //Salva o usuário no banco de dados.
	        return userRepository.save(user);
	    }
}
