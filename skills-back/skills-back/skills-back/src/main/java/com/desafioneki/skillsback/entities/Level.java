package com.desafioneki.skillsback.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "level")
public class Level {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id_level")	
	private Integer id_level;
    
    @NotBlank
	@Column(name = "level")
	private Integer level;
    
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    
    @ManyToMany(mappedBy = "levels")
    private Set<Skill> skills = new HashSet<>();

	public Integer getId_level() {
		return id_level;
	}

	public void setId_level(Integer id_level) {
		this.id_level = id_level;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
   
}
