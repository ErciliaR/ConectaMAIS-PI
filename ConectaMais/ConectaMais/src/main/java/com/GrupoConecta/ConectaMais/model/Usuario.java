package com.GrupoConecta.ConectaMais.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="tb_usuario")
public class Usuario {
	/* atributos */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long usuarioID; //id do usuário no nosso sistema
	
	@NotBlank
	@Max(99) 
	private String nome; //nome do usuário (estudantes e ongs)
	
	@NotBlank
	@Max(255)
	private String email; //email de cadastro
	
	@NotBlank
	@Max(10)
	private String senha; //senha de cadastro
	
	@Max(300)
	private String imagem_perfil_url; //imagem de perfil

	/* métodos */
	public long getUserID() {
		return usuarioID;
	}
     
	public void setUserID(long usuarioID) {
		this.usuarioID = usuarioID;
	}

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

	public String getImagem_perfil_url() {
		return imagem_perfil_url;
	}

	public void setImagem_perfil_url(String imagem_perfil_url) {
		this.imagem_perfil_url = imagem_perfil_url;
	}
}
