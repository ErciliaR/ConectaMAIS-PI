package com.GrupoConecta.ConectaMais.model;

public class LoginUsuario {

	/* atributos */
	private String nome; //nome do usuário (estudantes e ongs)
	
	private String email; //email de cadastro
		
	private String senha; //senha de cadastro
	
	private String papel; //definir o tipo de usuario para questões de segurança {admin, usuarioInstituicao, usuarioComum}

	private String token; //chave encriptografada

	/* métodos */
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

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
