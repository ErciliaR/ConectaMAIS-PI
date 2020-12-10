package com.GrupoConecta.ConectaMais.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GrupoConecta.ConectaMais.model.Instituicao;

@Repository
public interface InstituicaoRepositorio extends JpaRepository<Instituicao, Long>{
	
	@Query(value = "select * from tb_instituicao where idadeMin > :valor", nativeQuery = true)
	public List<Instituicao> IdadeMinSelecao (@Param("valor") int valor);
	
	//@Query(value = "select * from tb_instituicao where tb_instituicao.escolaridadeMin = nivel", nativeQuery = true)
	//public List<Instituicao> escolaridadeMinSelecao (@Param("nivel") enum nivel);
	
}
