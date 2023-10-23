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

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_skill")

@Entity
@Table(name = "skill", schema = "public")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_skill;

	@NotBlank
	@Column(name="imagem_url")
	private String imagem_url;
	
	@NotBlank
	@Column(name="nome")
	private String nome;
	
	@Column(name="level")
	private String level;
	
	@NotBlank
	@Column(name="descricao")
	private String descricao;

	@OneToMany(mappedBy = "skill")
	private List<UserSkills> userSkills;

	public Integer getId_skill() {
		return id_skill;
	}

	public void setId_skill(Integer id_skill) {
		this.id_skill = id_skill;
	}

	public String getImagem_url() {
		return imagem_url;
	}

	public void setImagem_url(String imagem_url) {
		this.imagem_url = imagem_url;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
