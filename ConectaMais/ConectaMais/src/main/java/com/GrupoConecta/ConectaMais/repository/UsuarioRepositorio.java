package com.GrupoConecta.ConectaMais.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GrupoConecta.ConectaMais.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	/*public List<Usuario> findByNomeContainingIgnoreCase (String nome); //filtrar por nome
	
	public List<Usuario> findByCidadeContainingIgnoreCase (String cidade); //filtrar por cidades
	
	@Query(value="select * from tb_usuario where idadeMin > :valor and instituicao <> null", nativeQuery=true)
	public List<Usuario> IdadeMinSelecao (@Param("valor") int valor); //filtrar idade minima
	
	@Query(value="select * from tb_usuario where idadeMax > :valor  and instituicao <> null", nativeQuery=true)
	public List<Usuario> IdadeMaxSelecao (@Param("valor") int valor); //filtrar idade maxima
	
	@Query(value="select * from tb_usuario where escolaridadeMin = :nivel and instituicao <> null", nativeQuery=true)
	public List<Usuario> escolaridadeMinSelecao (@Param("nivel") String nivel); //filtrar nivel de escolaridade
	
	@Query(value="select * from tb_usuario where generoSelecao = :genero and instituicao <> null", nativeQuery=true)
	public List<Usuario> generoSelecao (@Param("genero") String genero); //filtrar genero
	
	@Query(value="select * from tb_usuario where tipo = :opcao and instituicao <> null", nativeQuery=true)
	public List<Usuario> tipoAula (@Param("opcao") String opcao); //filtrar tipo ead, presencial ou os dois*/
	
}
