package com.desafioneki.skillsback.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.queryForList(sql);
    }
    
    public Map<String, Object> getUserById(int id_user) {
        String sql = "SELECT * FROM users WHERE id_user = ?";
        return jdbcTemplate.queryForMap(sql, id_user);
    }
    
    public void saveUser(String username, String senha) {
        String sql = "INSERT INTO users (username, senha) VALUES (?, ?)";
        jdbcTemplate.update(sql, username, senha);
    }
}
