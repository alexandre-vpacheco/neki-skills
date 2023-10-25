package com.desafioneki.skillsback.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

	   private final JdbcTemplate jdbcTemplate;

	    @Autowired
	    public SkillService(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    public List<Map<String, Object>> getAllSkills() {
	        String sql = "SELECT * FROM skills ORDER BY id_skill";
	        return jdbcTemplate.queryForList(sql);
	    }
	
}
