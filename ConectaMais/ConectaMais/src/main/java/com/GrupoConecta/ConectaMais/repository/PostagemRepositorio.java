package com.GrupoConecta.ConectaMais.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GrupoConecta.ConectaMais.model.Postagem;

@Repository
public interface PostagemRepositorio extends JpaRepository<Postagem, Long>{

	public List<Postagem> findAllByConteudoContainingIgnoreCase (String conteudo); //filtrar por conteúdo
	
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo); //filtrar por título
	
	public List<Postagem> findAllByTemaContainingIgnoreCase (String tema); //filtrar por tema
}
