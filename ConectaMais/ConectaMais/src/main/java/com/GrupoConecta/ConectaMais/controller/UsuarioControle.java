package com.GrupoConecta.ConectaMais.controller;

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
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> PeguePorID(@PathVariable long usuarioID){
		return repositorio01.findById(usuarioID).map(id -> ResponseEntity.ok(id)).orElse(ResponseEntity.notFound().build());
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
