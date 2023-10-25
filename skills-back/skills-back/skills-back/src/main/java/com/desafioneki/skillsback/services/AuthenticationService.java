package com.desafioneki.skillsback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	   private final JdbcTemplate jdbcTemplate;

	    @Autowired
	    public AuthenticationService(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    public boolean authenticateUser(String username, String senha) {
	        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND senha= ?";
	        int count = jdbcTemplate.queryForObject(sql, Integer.class, username, senha);
	        return count > 0;
	    }
}
