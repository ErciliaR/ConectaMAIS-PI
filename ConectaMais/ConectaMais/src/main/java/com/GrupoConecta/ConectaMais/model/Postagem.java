package com.GrupoConecta.ConectaMais.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class Postagem {
	/* atributos */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long postagemID; // id do postagem no nosso sistema

	@NotBlank
	@Max(100)
	private String titulo; // título da postagem

	@NotBlank
	@Max(500)
	private String conteudo; // conteúdo da postagem

	@NotNull
	private String tema; // tema da postagem: {inscricao, evento, noticias}

	@Column(name = "data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao = new java.sql.Date(System.currentTimeMillis()); // data de criação da postagem

	@Column(name = "data_atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao = new java.sql.Date(System.currentTimeMillis()); // data de atualizaçcão da postagem

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Instituicao instituicao;

	@OneToMany(mappedBy = "comentario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("postagem")
	private List<Comentario> comentario;

	/* método */
	public long getPostagemID() {
		return postagemID;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public String getTema() {
		return tema;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setPostagemID(long postagemID) {
		this.postagemID = postagemID;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
}
