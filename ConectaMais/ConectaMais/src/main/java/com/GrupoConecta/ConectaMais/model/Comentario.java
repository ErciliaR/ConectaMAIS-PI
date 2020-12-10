package com.GrupoConecta.ConectaMais.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_comentario")
public class Comentario {
	/* atributos */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long comentarioID; //id do comentário no nosso sistema
	
	@NotBlank
	@Max(255)
	private String conteudo; //conteúdo do comentário
	
	@Column(name="data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao = new java.sql.Date(System.currentTimeMillis()); //data de criação do comentário
	
	@Column(name="data_atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao = new java.sql.Date(System.currentTimeMillis()); //data de atualizaçcão do comentário

	@ManyToOne
	@JsonIgnoreProperties("comentario")
	private Usuario usuario;
	
	@ManyToOne
	@JsonIgnoreProperties("comentario")
	private Postagem postagem;

	/* método */
	public long getComentarioID() {
		return comentarioID;
	}

	public void setComentarioID(long comentarioID) {
		this.comentarioID = comentarioID;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
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
