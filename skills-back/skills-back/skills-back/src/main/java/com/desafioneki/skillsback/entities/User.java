package com.desafioneki.skillsback.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_user")

@Entity
@Table(name = "user", schema = "public")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_user;

	@NotBlank
	@Column(name="username", unique = true)
	private String username;

	@NotBlank
	@Column(name="senha")
	private String senha;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserSkill> userSkills = new ArrayList<>();
	
//	public User(Integer id_user, @NotBlank String username, @NotBlank String senha, List<UserSkill> userSkills) {
//		super();
//		this.id_user = id_user;
//		this.username = username;
//		this.senha = senha;
//		this.userSkills = userSkills;
//	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", username=" + username + ", senha=" + senha + ", userSkills=" + userSkills
				+ "]";
	}
}
