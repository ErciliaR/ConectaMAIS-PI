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

import com.GrupoConecta.ConectaMais.model.Comentario;
import com.GrupoConecta.ConectaMais.repository.ComentarioRepositorio;

@RestController
@RequestMapping("/comentario")
@CrossOrigin(value="*", allowedHeaders="*")
public class ComentarioControle {
	@Autowired
	private ComentarioRepositorio repositorio03;
	
	@GetMapping
	public ResponseEntity<List<Comentario>> PegarTodos(){
		return ResponseEntity.ok(repositorio03.findAll());
	}
	
	@GetMapping("/{comentarioID}")
	public ResponseEntity<Comentario> PegueID(@PathVariable long comentarioID){
		return repositorio03.findById(comentarioID).map(id -> ResponseEntity.ok(id)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/conteudo/{conteudoComentario}")
	public ResponseEntity<List<Comentario>> PegueConteudo(@PathVariable String conteudoComentario){
		return ResponseEntity.ok(repositorio03.findAllByConteudoComentarioContainingIgnoreCase(conteudoComentario));
	}
	
	@PostMapping
	public ResponseEntity<Comentario> CrieID(@RequestBody Comentario criado){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio03.save(criado));
	}
	
	@PutMapping
	public ResponseEntity<Comentario> AtualizeID(@RequestBody Comentario atualizado){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repositorio03.save(atualizado));
	}
	
	@DeleteMapping("/{comentarioID}")
	public void DeleteID(@PathVariable long comentarioID) {
		repositorio03.deleteById(comentarioID);
	}
}
