package com.desafioneki.skillsback.dto;

public class SkillAssociationDTO {
	
	private Integer id_user_fk;
    private Integer id_skill_fk;
    private String nivel;
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
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
    

}
