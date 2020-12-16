package com.GrupoConecta.ConectaMais.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GrupoConecta.ConectaMais.model.Usuario;
import com.GrupoConecta.ConectaMais.repository.UsuarioRepositorio;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(value="*", allowedHeaders="*")
public class UsuarioControle {
	
	@Autowired
	private UsuarioRepositorio repositorio01;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> PegueTodos(){
		return ResponseEntity.ok(repositorio01.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> PeguePorID(@PathVariable long usuarioID){
		return repositorio01.findById(usuarioID).map(id -> ResponseEntity.ok(id)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomeInstituicao/{nome}")
	public ResponseEntity<List<Usuario>> PeguePorNome(@PathVariable String nome){
		return ResponseEntity.ok(repositorio01.findByNomeContainingIgnoreCaseAndPapelIs(nome, "usuarioInstituicao"));
	}
	
	@GetMapping("/cidade/{cidade}")
	public ResponseEntity<List<Usuario>> PeguePorCidade(@PathVariable String cidade){
		return ResponseEntity.ok(repositorio01.findByCidadeContainingIgnoreCaseAndPapelIs(cidade, "usuarioInstituicao"));
	}
	
	@GetMapping("idadeMin/{idadeMin}")
	public ResponseEntity<List<Usuario>> PeguePorIdadeMin(@PathVariable int idadeMin){
		return ResponseEntity.ok(repositorio01.findByIdadeMinGreaterThanEqual(idadeMin));
	}
	
	@GetMapping("idadeMax/{idadeMax}")
	public ResponseEntity<List<Usuario>> PeguePorIdadeMax(@PathVariable int idadeMax){
		return ResponseEntity.ok(repositorio01.findByIdadeMaxLessThanEqual(idadeMax));
	}
	
	@GetMapping("esccolaridadeMin/{nivel}")
	public ResponseEntity<List<Usuario>> PeguePorEscolaridadeMin(@PathVariable String nivel){
		return ResponseEntity.ok(repositorio01.findByEscolaridadeMin(nivel));
	}
	
	@GetMapping("generoFoco/{genero}")
	public ResponseEntity<List<Usuario>> PeguePorGenero(@PathVariable String genero){
		return ResponseEntity.ok(repositorio01.findByGeneroSelecao(genero));
	}
	
	@GetMapping("tipoAula/{opcao}")
	public ResponseEntity<List<Usuario>> PeguePorTipo(@PathVariable String opcao){
		return ResponseEntity.ok(repositorio01.findByTipo(opcao));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> CrieID(@RequestBody Usuario criado){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio01.save(criado));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> AtualizeID(@RequestBody Usuario atualizado){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repositorio01.save(atualizado));
	}
	
	@DeleteMapping("/{id}")
	public void DeleteID(@PathVariable long usuariaID) {
		repositorio01.deleteById(usuariaID);
	}

}
