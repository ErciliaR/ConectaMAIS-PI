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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	@Size (min = 2, max = 500)
	@Column(name = "conteudo")
	private String conteudoComentario; //conteúdo do comentário
	
	@Column(name="data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacaoComentario = new java.sql.Date(System.currentTimeMillis()); //data de criação do comentário
	
	@Column(name="data_atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacaoComentario = new java.sql.Date(System.currentTimeMillis()); //data de atualizaçcão do comentário

	/* relação entre tabelas */
	@ManyToOne //declaração de relacionamento entre tabelas: comentário e usuário
	@JsonIgnoreProperties("comentarioObj") //declaraçao de chave estrageira da tabela, ignorando coluna comentário em tabela usuário
	private Usuario usuarioObj; //indicação do usuário que fez o comentário
	
	@ManyToOne //declaração de relacionamento entre tabelas: comentário e postagem
	@JsonIgnoreProperties("comentarioObj") //declaraçao de chave estrageira da tabela, ignorando coluna comentário em tabela postagem
	private Postagem postagemObj; //indicação da postagem na qual o comentário foi feito

	/* método */
	public long getComentarioID() {
		return comentarioID;
	}

	public void setComentarioID(long comentarioID) {
		this.comentarioID = comentarioID;
	}

	public String getConteudoComentario() {
		return conteudoComentario;
	}

	public void setConteudoComentario(String conteudoComentario) {
		this.conteudoComentario = conteudoComentario;
	}

	public Date getDataCriacaoComentario() {
		return dataCriacaoComentario;
	}

	public void setDataCriacaoComentario(Date dataCriacaoComentario) {
		this.dataCriacaoComentario = dataCriacaoComentario;
	}

	public Date getDataAtualizacaoComentario() {
		return dataAtualizacaoComentario;
	}

	public void setDataAtualizacaoComentario(Date dataAtualizacaoComentario) {
		this.dataAtualizacaoComentario = dataAtualizacaoComentario;
	}

	public Usuario getUsuarioObj() {
		return usuarioObj;
	}

	public void setUsuarioObj(Usuario usuarioObj) {
		this.usuarioObj = usuarioObj;
	}

	public Postagem getPostagemObj() {
		return postagemObj;
	}

	public void setPostagemObj(Postagem postagemObj) {
		this.postagemObj = postagemObj;
	}
	
}
