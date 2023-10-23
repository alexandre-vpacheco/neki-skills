package com.desafioneki.skillsback.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioneki.skillsback.dto.UserSkillDTO;
import com.desafioneki.skillsback.entities.Skill;
import com.desafioneki.skillsback.entities.User;
import com.desafioneki.skillsback.entities.UserSkill;
import com.desafioneki.skillsback.repositories.SkillRepository;
import com.desafioneki.skillsback.repositories.UserRepository;
import com.desafioneki.skillsback.repositories.UserSkillRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserSkillService {

    @Autowired
    private UserSkillRepository userSkillRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SkillRepository skillRepository;

    public List<UserSkillDTO> getSkillsByUserId(Integer id_user) {
        List<UserSkill> userSkills = userSkillRepository.findByUserId(id_user);
        List<UserSkillDTO> userSkillDTOs = new ArrayList<>();

        for (UserSkill userSkill : userSkills) {
            UserSkillDTO userSkillDTO = new UserSkillDTO();
            userSkillDTO.setId_user_skill(userSkill.getId_user_skill());
            userSkillDTO.setId_user_fk(userSkill.getUser().getId_user());
            userSkillDTO.setId_skill_fk(userSkill.getSkill().getId_skill());
            userSkillDTO.setLevel(userSkill.getLevel());
            userSkillDTOs.add(userSkillDTO);
        }

        return userSkillDTOs;
    }

    public void associateSkill(UserSkillDTO userSkillDTO) {
        // Verifica se o usuário e a skill existem.
        User user = userRepository.findById(userSkillDTO.getId_user_fk()).orElseThrow(() -> new EntityNotFoundException("User not found"));
        Skill skill = skillRepository.findById(userSkillDTO.getId_skill_fk()).orElseThrow(() -> new EntityNotFoundException("Skill not found"));

        // Cria a associação de UserSkill.
        UserSkill userSkill = new UserSkill();
        userSkill.setUser(user);
        userSkill.setSkill(skill);
        userSkill.setLevel(userSkillDTO.getLevel());

        userSkillRepository.save(userSkill);
    }
    
    public void updateSkillLevel(Integer id_user_skill, String newLevel) {
        UserSkill userSkill = userSkillRepository.findById(id_user_skill)
            .orElseThrow(() -> new EntityNotFoundException("UserSkill not found!"));

        userSkill.setLevel(newLevel);

        userSkillRepository.save(userSkill);
    }
    
    public void deleteSkillAssociation(Integer id_user_skill) {
        // Verifica se a associação de skill existe.
        UserSkill userSkill = userSkillRepository.findById(id_user_skill)
            .orElseThrow(() -> new EntityNotFoundException("UserSkill not found!"));

        // Exclui a associação de skill.
        userSkillRepository.delete(userSkill);
    }
    
    
    
}
