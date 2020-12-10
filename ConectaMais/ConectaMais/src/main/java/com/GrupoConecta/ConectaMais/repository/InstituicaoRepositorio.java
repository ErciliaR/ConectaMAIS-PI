package com.GrupoConecta.ConectaMais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GrupoConecta.ConectaMais.model.Instituicao;

@Repository
public interface InstituicaoRepositorio extends JpaRepository<Instituicao, Long>{

}
