package com.GrupoConecta.ConectaMais.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_instituicao")
public class Instituicao extends Usuario {
	/* atributos */        
	@NotBlank
	@Max(500)
	private String descricao; //descrição do programa, e.g.: valores, objetivos.
	
	@NotBlank
	@Max(255)
	private String cidade; //cidades onde atua
		
	@NotNull
	@Min(0)
	private int idadeMin; //idade mínima da seleção
	
	@NotNull
	@Min(0)
	private int idadeMax; //idade máxima da seleção
	
	@NotBlank
	private String escolaridadeMin; //escolaridade mínima da seleção
	
	@NotBlank
	private String generoSelecao; //gênero que participam na seleção
	
	@NotBlank
	private String tipo; //presencial, EAD ou os dois

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
