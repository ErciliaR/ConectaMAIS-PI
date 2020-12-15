package com.GrupoConecta.ConectaMais.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_usuario")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) //define a forma de herança aplicada entre classe usuário e instituição
@DiscriminatorColumn(name="discriminator", discriminatorType=DiscriminatorType.STRING) //define nome da coluna e o tipo de variavel que irá distiguir classe usuário e instituição
@DiscriminatorValue(value="usuarioComum") //define o valor do descriminador para a classe usuário 
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
	@Min(5)
	@Max(10)
	private String senha; //senha de cadastro
	
	@Max(300)
	private String imagem_perfil_url; //imagem de perfil
	
	/* relação entre tabelas */
	@OneToMany(mappedBy="usuarioObj", cascade = CascadeType.ALL) //mapeamento por coluna usuario e efeito cascata em tabela comentário
	@JsonIgnoreProperties("usuarioObj") //declaraçao de chave estrageira da tabela comentário, ignorando coluna usuário
	private List<Comentario> comentarioObj; //listagem dos comentarios feitos pelo usuário

	/* métodos */
	public long getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(long usuarioID) {
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

	public List<Comentario> getComentarioObj() {
		return comentarioObj;
	}

	public void setComentarioObj(List<Comentario> comentarioObj) {
		this.comentarioObj = comentarioObj;
	}
}
