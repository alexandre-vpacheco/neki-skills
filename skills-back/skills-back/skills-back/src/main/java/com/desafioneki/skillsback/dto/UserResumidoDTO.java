package com.desafioneki.skillsback.dto;

public class UserResumidoDTO {

	private Integer id_user;
	private String username;
	private String senha;
	

	public UserResumidoDTO() {

	}

	public UserResumidoDTO(Integer id_user, String username, String senha) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.senha = senha;
	}

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
}
