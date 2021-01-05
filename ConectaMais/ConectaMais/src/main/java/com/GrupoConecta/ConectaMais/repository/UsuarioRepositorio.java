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
	
	public List<Usuario> findByIdadeMinGreaterThanEqualAndPapelIs (int idadeMin, String papel); //filtrar idade minima
	
	public List<Usuario> findByIdadeMaxLessThanEqualAndPapelIs (int idadeMax, String papel); //filtrar idade maxima
	
	public List<Usuario> findByEscolaridadeMinContainingIgnoreCaseAndPapelIs (String nivel, String papel); //filtrar nivel de escolaridade
	
	public List<Usuario> findByGeneroSelecaoContainingIgnoreCaseAndPapelIs (String genero, String papel); //filtrar genero
	
	public List<Usuario> findByTipoContainingIgnoreCaseAndPapelIs (String tipo, String papel); //filtrar tipo ead, presencial ou os dois

}
