package com.desafioneki.skillsback.dto;

public class SkillsResumidasDTO {

	private Integer id_skill;
	private String imagem_url;
	private String nome;
	private String level;
	private String descricao;
	
	public SkillsResumidasDTO() {

	}

	public SkillsResumidasDTO(Integer id_skill, String imagem_url, String nome, String level, String descricao) {
		super();
		this.id_skill = id_skill;
		this.imagem_url = imagem_url;
		this.nome = nome;
		this.level = level;
		this.descricao = descricao;
	}

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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
