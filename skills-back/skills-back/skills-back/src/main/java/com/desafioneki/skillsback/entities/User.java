package com.desafioneki.skillsback.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;

	@NotBlank
    @Column(unique = true)
    private String username;

	@NotBlank
    private String senha;

    @OneToMany(mappedBy = "user")
    private List<UserSkills> userSkills;

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

	public List<UserSkills> getUserSkills() {
		return userSkills;
	}

	public void setUserSkills(List<UserSkills> userSkills) {
		this.userSkills = userSkills;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}       
}
