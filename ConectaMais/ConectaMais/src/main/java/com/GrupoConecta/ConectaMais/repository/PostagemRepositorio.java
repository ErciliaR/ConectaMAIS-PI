package com.GrupoConecta.ConectaMais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GrupoConecta.ConectaMais.model.Postagem;

@Repository
public interface PostagemRepositorio extends JpaRepository<Postagem, Long>{

}
