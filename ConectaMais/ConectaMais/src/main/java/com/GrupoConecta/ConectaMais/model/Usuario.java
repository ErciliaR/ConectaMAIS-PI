package com.GrupoConecta.ConectaMais.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_usuario")
public class Usuario {
	/* atributos */
	@Id //identifica a chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long usuarioID; //id do usuário no nosso sistema
	
	@NotBlank 
	@Size (min = 2, max = 99)
	private String nome; //nome do usuário (estudantes e ongs)
	
	@NotBlank
	@Size (min = 2, max = 255)
	private String email; //email de cadastro
	
	@NotBlank
	@Size (min = 5, max = 10)
	private String senha; //senha de cadastro
	
	@Size (min = 2, max = 500)
	private String imagemPerfilURL; //imagem de perfil
	
	@NotBlank
	@Size(min=5, max=20)
	private String papel; //definir o tipo de usuario para questões de segurança {admin, usuarioInstituicao, usuarioComum}
	
	/* atributos Instituição */        
	@Size (min = 2, max = 500)
	private String descricao; //descrição do programa, e.g.: valores, objetivos, premiacao de hackathon.
	
	@Size (min = 2, max = 255)
	private String cidade; //cidades onde atua
	
	@Min(0)
	private int idadeMin; //idade mínima da seleção
	
	@Min(0)
	private int idadeMax; //idade máxima da seleção
	

	@Size(min=3,max=20)
	private String escolaridadeMin; //escolaridade mínima da seleção: {medioIncompleto, medioCompleto, superiorIncompleto, superiorCompleto}

	@Size(min=3,max=20)
	private String generoSelecao; //gênero que participam na seleção: {femininoCISeTRANS, masculinoCISeTRANS, naoBinario, todos}
	
	@Size(min=3,max=20)
	private String tipo; //presencial, EAD ou os dois {presencial, ead, presencialEead}
	
	/* relação entre tabelas */
	@OneToMany(mappedBy="usuarioObj", cascade = CascadeType.ALL) //mapeamento por coluna usuario e efeito cascata em tabela comentário
	@JsonIgnoreProperties("usuarioObj") //declaraçao de chave estrageira da tabela comentário, ignorando coluna usuário
	private List<Comentario> comentarioObj; //listagem dos comentarios feitos pelo usuário
	
	@OneToMany(mappedBy="instituicaoObj", cascade=CascadeType.ALL) //mapeamento por coluna instituição e efeito cascata em tabela postagem
	@JsonIgnoreProperties("instituicaoObj") //declaraçao de chave estrageira da tabela postagem, ignorando coluna instituição
	private List<Postagem> postagemObj; //listagem das postagens feitas pela insituição

	/* métodos */
	public long getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(long usuarioID) {
		this.usuarioID = usuarioID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getImagem_perfil_url() {
		return imagemPerfilURL;
	}

	public void setImagem_perfil_url(String imagemPerfilURL) {
		this.imagemPerfilURL = imagemPerfilURL;
	}
	
	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

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
	
	public List<Comentario> getComentarioObj() {
		return comentarioObj;
	}

	public void setComentarioObj(List<Comentario> comentarioObj) {
		this.comentarioObj = comentarioObj;
	}

	public List<Postagem> getPostagemObj() {
		return postagemObj;
	}

	public void setPostagemObj(List<Postagem> postagemObj) {
		this.postagemObj = postagemObj;
	}
}
