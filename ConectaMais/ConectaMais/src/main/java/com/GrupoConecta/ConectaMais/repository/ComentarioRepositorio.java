package com.GrupoConecta.ConectaMais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GrupoConecta.ConectaMais.model.Comentario;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, Long>{

}
