package com.desafioneki.skillsback.dto;

public class UserSkillDTO {

	private Integer id_user_skill;
	
	private Integer id_user_fk;
	private Integer id_skill_fk;
	private String level;

	public UserSkillDTO() {
		super();
	}

	public UserSkillDTO(Integer id_user_skill, Integer id_user_fk, Integer id_skill_fk, String level) {
		super();
		this.id_user_skill = id_user_skill;
		this.id_user_fk = id_user_fk;
		this.id_skill_fk = id_skill_fk;
		this.level = level;
	}

	public Integer getId_user_skill() {
		return id_user_skill;
	}

	public void setId_user_skill(Integer id_user_skill) {
		this.id_user_skill = id_user_skill;
	}

	public Integer getId_user_fk() {
		return id_user_fk;
	}

	public void setId_user_fk(Integer id_user_fk) {
		this.id_user_fk = id_user_fk;
	}

	public Integer getId_skill_fk() {
		return id_skill_fk;
	}

	public void setId_skill_fk(Integer id_skill_fk) {
		this.id_skill_fk = id_skill_fk;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
