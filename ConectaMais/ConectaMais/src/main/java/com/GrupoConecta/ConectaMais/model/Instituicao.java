package com.GrupoConecta.ConectaMais.model;

import javax.persistence.Embeddable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Embeddable
public class Instituicao {
	/* atributos */        
	@Max(500)
	private String descricao; //descrição do programa, e.g.: valores, objetivos, premiacao de hackathon.
	
	@Max(255)
	private String cidade; //cidades onde atua
	
	@Min(0)
	@Max(99)
	private int idadeMin; //idade mínima da seleção
	
	@Min(0)
	@Max(99)
	private int idadeMax; //idade máxima da seleção
	

	@Size(min=3,max=20)
	private String escolaridadeMin; //escolaridade mínima da seleção: {medioIncompleto, medioCompleto, superiorIncompleto, superiorCompleto}

	@Size(min=3,max=20)
	private String generoSelecao; //gênero que participam na seleção: {femininoCISeTRANS, masculinoCISeTRANS, naoBinario, todos}
	
	@Size(min=3,max=20)
	private String tipo; //presencial, EAD ou os dois {presencial, ead, presencialEead}
	
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
}
