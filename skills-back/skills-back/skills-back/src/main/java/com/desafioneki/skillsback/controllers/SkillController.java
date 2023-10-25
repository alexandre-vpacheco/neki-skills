package com.desafioneki.skillsback.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioneki.skillsback.services.SkillService;

@RestController
public class SkillController {

    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/skills")
    public List<Map<String, Object>> getAllSkills() {
        return skillService.getAllSkills();
    }
	
}
