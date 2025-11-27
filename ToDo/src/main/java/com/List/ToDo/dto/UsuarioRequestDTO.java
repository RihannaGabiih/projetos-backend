package com.List.ToDo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDTO {

	@NotBlank(message = "Digite um nome valido")
	private String nome;
	@NotBlank(message = "Digte um email valido")
	private String email;
	@Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres")
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
