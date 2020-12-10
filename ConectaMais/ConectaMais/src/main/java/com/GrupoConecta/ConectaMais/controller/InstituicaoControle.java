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

import com.GrupoConecta.ConectaMais.model.Instituicao;
import com.GrupoConecta.ConectaMais.repository.InstituicaoRepositorio;

@RestController
@RequestMapping("/instituicao")
@CrossOrigin(value="*", allowedHeaders="*")
public class InstituicaoControle {
	@Autowired
	private InstituicaoRepositorio repositorio02;
	
	@GetMapping("/{id}")
	public ResponseEntity<Instituicao> PegueID(@PathVariable long usuarioID){
		return repositorio02.findById(usuarioID).map(id -> ResponseEntity.ok(id)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Instituicao>> PegueNome(@PathVariable String nome){
		return ResponseEntity.ok(repositorio02.findByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/cidade/{cidade}")
	public ResponseEntity<List<Instituicao>> PegueCidade(@PathVariable String cidade){
		return ResponseEntity.ok(repositorio02.findByCidadeContainingIgnoreCase(cidade));
	}
	
	@GetMapping("/idademinima/{valor}")
	public ResponseEntity<List<Instituicao>> PegueValorIdadeMin(@PathVariable int valor){ 
		return ResponseEntity.ok(repositorio02.IdadeMinSelecao(valor));
	}
	
	@GetMapping("/idademaxima/{valor}")
	public ResponseEntity<List<Instituicao>> PegueValorIdadeMax(@PathVariable int valor){ 
		return ResponseEntity.ok(repositorio02.IdadeMaxSelecao(valor));
	}
	
	@GetMapping("/escolaridademin/{nivel}")
	public ResponseEntity<List<Instituicao>> PegueNivelEscolaridade(@PathVariable String nivel){ 
		return ResponseEntity.ok(repositorio02.escolaridadeMinSelecao(nivel));
	}
	
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<Instituicao>> PegueGenero(@PathVariable String genero){ 
		return ResponseEntity.ok(repositorio02.generoSelecao(genero));
	}
	
	@GetMapping("/tipo/{opcao}")
	public ResponseEntity<List<Instituicao>> PegueTipo(@PathVariable String opcao){ 
		return ResponseEntity.ok(repositorio02.tipoAula(opcao));
	}
	
	@PostMapping
	public ResponseEntity<Instituicao> CrieID(@RequestBody Instituicao criado){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio02.save(criado));
	}
	
	@PutMapping
	public ResponseEntity<Instituicao> AtualizeID(@RequestBody Instituicao atualizado){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repositorio02.save(atualizado));
	}
	
	@DeleteMapping("/{id}")
	public void DeleteID(@PathVariable long usuariaID) {
		repositorio02.deleteById(usuariaID);
	}
}
