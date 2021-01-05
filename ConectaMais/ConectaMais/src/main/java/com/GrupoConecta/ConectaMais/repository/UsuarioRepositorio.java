package com.GrupoConecta.ConectaMais.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GrupoConecta.ConectaMais.model.Usuario;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	public Optional<Usuario> findByEmail(String email);

	public List<Usuario> findByNomeContainingIgnoreCaseAndPapelIs (String nome, String papel); //filtrar por nome das instituições
	
	public List<Usuario> findByCidadeContainingIgnoreCaseAndPapelIs (String cidade, String papel); //filtrar por cidades das instituições
	
	public List<Usuario> findByIdadeMinGreaterThanEqual (int idadeMin); //filtrar idade minima
	
	public List<Usuario> findByIdadeMaxLessThanEqual (int idadeMax); //filtrar idade maxima
	
	public List<Usuario> findByEscolaridadeMinContainingIgnoreCase (String nivel); //filtrar nivel de escolaridade
	
	public List<Usuario> findByGeneroSelecaoContainingIgnoreCase (String genero); //filtrar genero
	
	public List<Usuario> findByTipoContainingIgnoreCase (String tipo); //filtrar tipo ead, presencial ou os dois

}
