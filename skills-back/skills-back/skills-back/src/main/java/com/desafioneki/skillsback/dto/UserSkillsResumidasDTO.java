package com.desafioneki.skillsback.dto;

public class UserSkillsResumidasDTO {

	private Integer id_user_skill;
	private Integer id_user;
	private Integer id_skill;
	private String level;
	
	public UserSkillsResumidasDTO() {
		super();
	}

	public UserSkillsResumidasDTO(Integer id_user_skill, Integer id_user, Integer id_skill, String level) {
		super();
		this.id_user_skill = id_user_skill;
		this.id_user = id_user;
		this.id_skill = id_skill;
		this.level = level;
	}

	public Integer getId_user_skill() {
		return id_user_skill;
	}

	public void setId_user_skill(Integer id_user_skill) {
		this.id_user_skill = id_user_skill;
	}

	
	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getId_skill() {
		return id_skill;
	}

	public void setId_skill(Integer id_skill) {
		this.id_skill = id_skill;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
