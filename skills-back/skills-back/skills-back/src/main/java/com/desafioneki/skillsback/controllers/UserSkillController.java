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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioneki.skillsback.dto.UserSkillDTO;
import com.desafioneki.skillsback.repositories.UserRepository;
import com.desafioneki.skillsback.services.UserSkillService;

@RestController
@RequestMapping("/user_skills")
public class UserSkillController {

	@Autowired
	UserSkillService userSkillService;
	
	@Autowired
	UserRepository userRepository;
	
    @GetMapping("/{id_user}/skills")
    public ResponseEntity<List<UserSkillDTO>> getSkillsByUserId(@PathVariable Integer id_user) {
        List<UserSkillDTO> userSkills = userSkillService.getSkillsByUserId(id_user);
        return new ResponseEntity<>(userSkills, HttpStatus.OK);
    }
    
    @PostMapping("/associate")
    public ResponseEntity<String> associateSkill(@RequestBody UserSkillDTO userSkillDTO) {
        userSkillService.associateSkill(userSkillDTO);
        return ResponseEntity.ok("Skill associada com sucesso!");
    }
    
    
    @PatchMapping("/{id_user_skill}")
    public ResponseEntity<String> updateSkillLevel(
        @PathVariable Integer id_user_skill,
        @RequestBody Map<String, String> request) {
        String newLevel = request.get("level");
        userSkillService.updateSkillLevel(id_user_skill, newLevel);
        return ResponseEntity.ok("Skill level updated successfully");
    }
    
    @DeleteMapping("/delete/{id_user_skill}")
    public ResponseEntity<String> deleteSkillAssociation(@PathVariable Integer id_user_skill) {
        userSkillService.deleteSkillAssociation(id_user_skill);
        return ResponseEntity.ok("Associação de skill deletada com sucesso!");
    }
}
