package com.desafioneki.skillsback.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "user_skill", schema = "public")
public class UserSkill {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user_skill;
    
    @ManyToOne
    @JoinColumn(name = "id_user_fk")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_skill_fk")
    private Skill skill;

    @NotBlank
    @Column(name = "level")
    private String level;

	public Integer getId_user_skill() {
		return id_user_skill;
	}

	public void setId_user_skill(Integer id_user_skill) {
		this.id_user_skill = id_user_skill;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	} 
}
