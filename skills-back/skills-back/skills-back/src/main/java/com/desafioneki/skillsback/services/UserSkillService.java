package com.desafioneki.skillsback.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserSkillService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserSkillService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> getSkillsForUser(Integer id_user) {
        String sql = "SELECT s.id_skill, s.imagem_url, s.nome_skill, us.nivel, s.descricao " +
                     "FROM users_skills us " +
                     "INNER JOIN skills s ON us.id_skill_fk = s.id_skill " +
                     "WHERE us.id_user_fk = ?";
        return jdbcTemplate.queryForList(sql, id_user);
    }
    
    public void associateSkillWithUser(Integer id_user, Integer id_skill, String nivel) {
        String sql = "INSERT INTO users_skills (id_user_fk, id_skill_fk, nivel) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, id_user, id_skill, nivel);
    }
    

    public void updateSkillLevel(int id_user_skill, String newNivel) {
        String sql = "UPDATE users_skills SET nivel = CAST(? AS VARCHAR) WHERE id_user_skill = ?";
        jdbcTemplate.update(sql, newNivel, id_user_skill);
    }
    
    public void deleteSkill(int idUserSkill) {
        String sql = "DELETE FROM users_skills WHERE id_user_skill = ?";
        jdbcTemplate.update(sql, idUserSkill);
    }
}
