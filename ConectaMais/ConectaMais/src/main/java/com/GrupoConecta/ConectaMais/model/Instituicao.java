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
		
	@NotBlank
	@Min(0)
	@Max(99)
	private int idadeMin; //idade mínima da seleção
	
	@NotBlank
	@Min(0)
	@Max(99)
	private int idadeMax; //idade máxima da seleção
	
	@NotNull
	private enum escolaridadeMin {
		medioIncompleto, medioCompleto, superiorIncompleto, superiorCompleto}; //escolaridade mínima da seleção
	
	@NotNull
	private enum generoSelecao{
		femininoCISeTRANS, masculinoCISeTRANS, naoBinario, todos}; //gênero que participam na seleção
	
	@NotNull
	private enum tipo{
		presencial, ead, presencialEead}; //presencial, EAD ou os dois

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
}
