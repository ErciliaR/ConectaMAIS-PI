package com.GrupoConecta.ConectaMais.controller;


import java.util.List;
import java.util.Optional;

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

import com.GrupoConecta.ConectaMais.model.LoginUsuario;
import com.GrupoConecta.ConectaMais.model.Usuario;
import com.GrupoConecta.ConectaMais.repository.UsuarioRepositorio;
import com.GrupoConecta.ConectaMais.service.UserService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(value="*", allowedHeaders="*")
public class UsuarioControle {
	
	@Autowired
	private UsuarioRepositorio repositorio01;
	
	@Autowired
	private UserService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> PegueTodos(){
		return ResponseEntity.ok(repositorio01.findAll());
	}
	
	@GetMapping("/{usuarioID}")
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
	
	@GetMapping("escolaridadeMin/{nivel}")
	public ResponseEntity<List<Usuario>> PeguePorEscolaridadeMin(@PathVariable String nivel){
		return ResponseEntity.ok(repositorio01.findByEscolaridadeMinContainingIgnoreCase(nivel));
	}
	
	@GetMapping("generoFoco/{genero}")
	public ResponseEntity<List<Usuario>> PeguePorGenero(@PathVariable String genero){
		return ResponseEntity.ok(repositorio01.findByGeneroSelecaoContainingIgnoreCase(genero));
	}
	
	@GetMapping("tipoAula/{opcao}")
	public ResponseEntity<List<Usuario>> PeguePorTipo(@PathVariable String opcao){
		return ResponseEntity.ok(repositorio01.findByTipoContainingIgnoreCase(opcao));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> CrieID(@RequestBody Usuario criado){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio01.save(criado));
	}
	
	@PostMapping("/logar")
	public ResponseEntity<LoginUsuario> Autenticcar(@RequestBody Optional<LoginUsuario> loginUsuario){
		return usuarioService.Logar(loginUsuario).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> CadastrarID(@RequestBody Usuario usuario){
		Usuario func = usuarioService.CadastrarUsuario(usuario);
		if(func == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(func);
	}
	
	@PutMapping
	public ResponseEntity<Usuario> AtualizeID(@RequestBody Usuario atualizado){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repositorio01.save(atualizado));
	}
	
	@DeleteMapping("/{usuarioID}")
	public void DeleteID(@PathVariable long usuarioID) {
		repositorio01.deleteById(usuarioID);
	}

}
