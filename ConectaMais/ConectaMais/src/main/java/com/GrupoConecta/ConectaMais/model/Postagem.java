package com.GrupoConecta.ConectaMais.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="tb_postagem")
public class Postagem {
	/* atributos */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long postagemID; //id do postagem no nosso sistema
	
	@NotBlank
	@Max(100)
	private String titulo; //título da postagem
	
	@NotBlank
	@Max(500)
	private String conteudo; //conteúdo da postagem
	
	@NotBlank
	private String tema; //tema da postagem: inscriçao, evento e noticias
	
	@Column(name="data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao = new java.sql.Date(System.currentTimeMillis()); //data de criação da postagem
	
	@Column(name="data_atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao = new java.sql.Date(System.currentTimeMillis()); //data de atualizaçcão da postagem
	
	//FALTA A FOREGIN KEY USUARIO (INSTITUICAO)

	/* método */
	public long getPostagemID() {
		return postagemID;
	}

	public void setPostagemID(long postagemID) {
		this.postagemID = postagemID;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
}
