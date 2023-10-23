package com.desafioneki.skillsback.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioneki.skillsback.dto.SkillsResumidasDTO;
import com.desafioneki.skillsback.services.SkillService;


@RestController
@RequestMapping("/skills")
public class SkillController {

	@Autowired
	SkillService skillService;
	
	@Autowired
	@GetMapping("/skills")
	public ResponseEntity<List<SkillsResumidasDTO>> findAllSkills() {
		return new ResponseEntity<>(skillService.findAllSkills(),
				HttpStatus.OK);
	}
	
}
