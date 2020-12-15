package com.GrupoConecta.ConectaMais.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GrupoConecta.ConectaMais.model.Comentario;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, Long>{

	public List<Comentario> findAllByConteudoComentarioContainingIgnoreCase (String conteudoComentario); //filtrar por conteúdo
	
}
