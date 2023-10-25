package com.desafioneki.skillsback.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafioneki.skillsback.dto.SkillAssociationDTO;
import com.desafioneki.skillsback.services.UserSkillService;

@RestController
public class UserSkillController {
	
    private final UserSkillService userSkillService;

    @Autowired
    public UserSkillController(UserSkillService userSkillService) {
        this.userSkillService = userSkillService;
    }

    @GetMapping("/users_skills/{id_user}/skills")
    public List<Map<String, Object>> getSkillsForUser(@PathVariable Integer id_user) {
        return userSkillService.getSkillsForUser(id_user);
    }
    
    @PostMapping("/users_skills/associate")
    public ResponseEntity<String> associateSkillWithUser(@RequestBody SkillAssociationDTO skillAssociationDTO) {
        userSkillService.associateSkillWithUser(skillAssociationDTO.getId_user_fk(), skillAssociationDTO.getId_skill_fk(), skillAssociationDTO.getNivel());
        return new ResponseEntity<>("Skill associada com sucesso!", HttpStatus.CREATED);
    }
    
    @PatchMapping("/users_skills/{id_user_skill}")
    public ResponseEntity<String> updateSkillLevel(
            @PathVariable Integer id_user_skill,
            @RequestBody Map<String, String> requestBody) {
        String level = requestBody.get("level");
        userSkillService.updateSkillLevel(id_user_skill, level);
        return new ResponseEntity<>("Nivel de skill atualizado!", HttpStatus.OK);
    }
    
    @DeleteMapping("/users_skills/delete/{id_user_skill}")
    public ResponseEntity<String> deleteSkill(@PathVariable Integer id_user_skill) {
        userSkillService.deleteSkill(id_user_skill);
        return new ResponseEntity<>("Associação de skill desfeita!", HttpStatus.OK);
    }
}
