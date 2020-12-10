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

import com.GrupoConecta.ConectaMais.model.Postagem;
import com.GrupoConecta.ConectaMais.repository.PostagemRepositorio;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(value="*", allowedHeaders="*")
public class PostagemControle {
	@Autowired
	private PostagemRepositorio repositorio03;
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> PegueID(@PathVariable long postagemID){
		return repositorio03.findById(postagemID).map(id -> ResponseEntity.ok(id)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Postagem> CrieID(@RequestBody Postagem criado){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio03.save(criado));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> AtualizeID(@RequestBody Postagem atualizado){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repositorio03.save(atualizado));
	}
	
	@DeleteMapping("/{id}")
	public void DeleteID(@PathVariable long postagemID) {
		repositorio03.deleteById(postagemID);
	}
}
