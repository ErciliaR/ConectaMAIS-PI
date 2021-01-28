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

import com.GrupoConecta.ConectaMais.model.Postagem;
import com.GrupoConecta.ConectaMais.repository.PostagemRepositorio;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins="*", allowedHeaders="*")
public class PostagemControle {
	@Autowired
	private PostagemRepositorio repositorio02;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> PagarTodos(){
		return ResponseEntity.ok(repositorio02.findAll());
	}
	
	@GetMapping("/{postagemID}")
	public ResponseEntity<Postagem> PegueID(@PathVariable long postagemID){
		return repositorio02.findById(postagemID).map(id -> ResponseEntity.ok(id)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/conteudo/{conteudoPostagem}")
	public ResponseEntity<List<Postagem>> PegueConteudo(@PathVariable String conteudoPostagem){
		return ResponseEntity.ok(repositorio02.findAllByConteudoPostagemContainingIgnoreCase(conteudoPostagem));
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> PegueTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repositorio02.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@GetMapping("/tema/{tema}")
	public ResponseEntity<List<Postagem>> PegueTema(@PathVariable String tema){
		return ResponseEntity.ok(repositorio02.findAllByTemaContainingIgnoreCase(tema));
	}
	
	@PostMapping
	public ResponseEntity<Postagem> CrieID(@RequestBody Postagem criado){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio02.save(criado));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> AtualizeID(@RequestBody Postagem atualizado){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repositorio02.save(atualizado));
	}
	
	@DeleteMapping("/{postagemID}")
	public void DeleteID(@PathVariable long postagemID) {
		repositorio02.deleteById(postagemID);
	}
}
