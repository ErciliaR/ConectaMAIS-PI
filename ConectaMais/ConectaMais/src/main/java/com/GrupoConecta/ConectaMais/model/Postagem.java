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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	@Size (min = 2, max = 255)
	private String titulo; // título da postagem

	@NotBlank
	@Size (min = 2, max = 500)
	@Column(name = "conteudo")
	private String conteudoPostagem; // conteúdo da postagem

	@NotBlank
	@Size (min = 2, max = 10)
	private String tema; // tema da postagem: {inscricao, evento, noticias}

	@Column(name = "data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacaoPostagem = new java.sql.Date(System.currentTimeMillis()); // data de criação da postagem

	@Column(name = "data_atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacaoPostagem = new java.sql.Date(System.currentTimeMillis()); // data de atualizaçcão da postagem

	/* relação entre tabelas */
	@OneToMany(mappedBy = "postagemObj", cascade = CascadeType.REMOVE) //mapeamento por coluna postagem e efeito cascata em tabela comentário
	@JsonIgnoreProperties(value = {"postagemObj"}) //declaraçao de chave estrageira da tabela comentário, ignorando coluna postagem
	private List<Comentario> comentarioObj; //listagem dos comentários feitas na postagem

	
	@ManyToOne //declaração de relacionamento entre tabelas: postagem e usuário instituição
	@JsonIgnoreProperties(value = {"postagemObj", "comentarioObj"}) //declaraçao de chave estrageira da tabela, ignorando coluna postagem em tabela instituição
	private Usuario instituicaoObj; //indicação da insituição que fez a postagem

	
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

	public String getConteudoPostagem() {
		return conteudoPostagem;
	}

	public void setConteudoPostagem(String conteudoPostagem) {
		this.conteudoPostagem = conteudoPostagem;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Date getDataCriacaoPostagem() {
		return dataCriacaoPostagem;
	}

	public void setDataCriacaoPostagem(Date dataCriacaoPostagem) {
		this.dataCriacaoPostagem = dataCriacaoPostagem;
	}

	public Date getDataAtualizacaoPostagem() {
		return dataAtualizacaoPostagem;
	}

	public void setDataAtualizacaoPostagem(Date dataAtualizacaoPostagem) {
		this.dataAtualizacaoPostagem = dataAtualizacaoPostagem;
	}

	public Usuario getInstituicaoObj() {
		return instituicaoObj;
	}

	public void setInstituicaoObj(Usuario instituicaoObj) {
		this.instituicaoObj = instituicaoObj;
	}

	public List<Comentario> getComentarioObj() {
		return comentarioObj;
	}

	public void setComentarioObj(List<Comentario> comentarioObj) {
		this.comentarioObj = comentarioObj;
	}
}
