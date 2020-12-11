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

	@ManyToOne //declaração de relacionamento entre tabelas: comentário e usuário
	@JsonIgnoreProperties("comentario") //declaraçao de chave estrageira da tabela, ignorando coluna comentário em tabela usuário
	private Usuario usuario; //indicação do usuário que fez o comentário
	
	@ManyToOne //declaração de relacionamento entre tabelas: comentário e postagem
	@JsonIgnoreProperties("comentario") //declaraçao de chave estrageira da tabela, ignorando coluna comentário em tabela postagem
	private Postagem postagem; //indicação da postagem na qual o comentário foi feito

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
