package com.desafioneki.skillsback.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioneki.skillsback.dto.SkillsResumidasDTO;
import com.desafioneki.skillsback.entities.Skill;
import com.desafioneki.skillsback.repositories.SkillRepository;

@Service
public class SkillService {
	@Autowired
	SkillRepository skillRepository;

//	@Autowired
//	public List<Skill> findAllSkills() {
//		List<Skill> listSkills = skillRepository.findAll();
//		return listSkills;
//	}
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<SkillsResumidasDTO> findAllSkills() {
		List<Skill> listaSkills = skillRepository.findAll();
		List<SkillsResumidasDTO> listaSkillsDTO = modelMapper.map(listaSkills, new TypeToken<List<SkillsResumidasDTO>>(){}.getType());		
//		List<UsuarioDTO> listUsuDTO = Arrays.asList(modelMapper.map(listUsuarios, UsuarioDTO[].class));
		return listaSkillsDTO;
	}
}
