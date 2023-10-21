package com.desafioneki.skillsback.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "skill")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_skill")
	private Integer id_skill;

	@NotBlank
	@Column(name = "nome_skill")
	private String nome_skill;

	@NotBlank
	@Column(name = "imagem_url")
	private String imagem_url;

	@Column(name = "imagem_nome")
	private String imagem_nome;

	@Column(name = "imagem_filename")
	private String imagem_filename;

	@NotBlank
	@Column(name = "descricao")
	private String descricao;

	@NotBlank
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@ManyToMany
    @JoinTable(
        name = "skill_level",
        joinColumns = @JoinColumn(name = "skill_id"),
        inverseJoinColumns = @JoinColumn(name = "level_id")
    )
    private Set<Level> levels = new HashSet<>();

	public Integer getId_skill() {
		return id_skill;
	}

	public void setId_skill(Integer id_skill) {
		this.id_skill = id_skill;
	}

	public String getNome_skill() {
		return nome_skill;
	}

	public void setNome_skill(String nome_skill) {
		this.nome_skill = nome_skill;
	}

	public String getImagem_url() {
		return imagem_url;
	}

	public void setImagem_url(String imagem_url) {
		this.imagem_url = imagem_url;
	}

	public String getImagem_nome() {
		return imagem_nome;
	}

	public void setImagem_nome(String imagem_nome) {
		this.imagem_nome = imagem_nome;
	}

	public String getImagem_filename() {
		return imagem_filename;
	}

	public void setImagem_filename(String imagem_filename) {
		this.imagem_filename = imagem_filename;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Level> getLevels() {
		return levels;
	}

	public void setLevels(Set<Level> levels) {
		this.levels = levels;
	}
}
