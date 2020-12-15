package com.GrupoConecta.ConectaMais.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_instituicao")
@DiscriminatorValue("usuarioInstituicao") //define o valor do descriminador para a classe instituição 
public class Instituicao extends Usuario {
	/* atributos */        
	@NotBlank
	@Max(500)
	private String descricao; //descrição do programa, e.g.: valores, objetivos, premiacao de hackathon.
	
	@NotBlank
	@Max(255)
	private String cidade; //cidades onde atua
	
	@NotNull
	@Min(0)
	@Max(99)
	private int idadeMin; //idade mínima da seleção
	
	@NotNull
	@Min(0)
	@Max(99)
	private int idadeMax; //idade máxima da seleção
	
	@NotBlank
	@Size(min=3,max=20)
	private String escolaridadeMin; //escolaridade mínima da seleção: {medioIncompleto, medioCompleto, superiorIncompleto, superiorCompleto}
	
	@NotBlank
	@Size(min=3,max=20)
	private String generoSelecao; //gênero que participam na seleção: {femininoCISeTRANS, masculinoCISeTRANS, naoBinario, todos}
	
	@NotBlank
	@Size(min=3,max=20)
	private String tipo; //presencial, EAD ou os dois {presencial, ead, presencialEead}
	
	/* relação entre tabelas */
	@OneToMany(mappedBy="instituicaoObj", cascade=CascadeType.ALL) //mapeamento por coluna instituição e efeito cascata em tabela postagem
	@JsonIgnoreProperties("instituicaoObj") //declaraçao de chave estrageira da tabela postagem, ignorando coluna instituição
	private List<Postagem> postagemObj; //listagem das postagens feitas pela insituição

	/* método */
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getIdadeMin() {
		return idadeMin;
	}

	public void setIdadeMin(int idadeMin) {
		this.idadeMin = idadeMin;
	}

	public int getIdadeMax() {
		return idadeMax;
	}

	public void setIdadeMax(int idadeMax) {
		this.idadeMax = idadeMax;
	}

	public String getEscolaridadeMin() {
		return escolaridadeMin;
	}

	public void setEscolaridadeMin(String escolaridadeMin) {
		this.escolaridadeMin = escolaridadeMin;
	}

	public String getGeneroSelecao() {
		return generoSelecao;
	}

	public void setGeneroSelecao(String generoSelecao) {
		this.generoSelecao = generoSelecao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Postagem> getPostagemObj() {
		return postagemObj;
	}

	public void setPostagemObj(List<Postagem> postagemObj) {
		this.postagemObj = postagemObj;
	}
}
