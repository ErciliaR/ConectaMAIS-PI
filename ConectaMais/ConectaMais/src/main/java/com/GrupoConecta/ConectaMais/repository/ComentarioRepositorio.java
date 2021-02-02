package com.GrupoConecta.ConectaMais.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GrupoConecta.ConectaMais.model.Comentario;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, Long>{

	public List<Comentario> findAllByConteudoComentarioContainingIgnoreCase (String conteudoComentario); //filtrar por conteúdo
	
	@Query (value="select * from tb_comentario where postagem_obj_id = :postId", nativeQuery=true)
	public List<Comentario> findAllComentarioByPostagemID(@Param("postId") long postId); //evitar recursividade no front
	
}
