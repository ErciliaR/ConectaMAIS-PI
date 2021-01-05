package com.GrupoConecta.ConectaMais.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.GrupoConecta.ConectaMais.model.LoginUsuario;
import com.GrupoConecta.ConectaMais.model.Usuario;
import com.GrupoConecta.ConectaMais.repository.UsuarioRepositorio;

@Service
public class UserService {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public Usuario CadastrarUsuario(Usuario usuario) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<Usuario> usuarioPresente = usuarioRepositorio.findByEmail(usuario.getEmail()); 
		//Alteração Marcelo - if
		if(usuarioPresente.isPresent()) {
			return null;
		}

		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);

		return usuarioRepositorio.save(usuario);
	}

	public Optional<LoginUsuario> Logar(Optional<LoginUsuario> loginUsuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = usuarioRepositorio.findByEmail(loginUsuario.get().getSenha());

		if (usuario.isPresent()) {
			if (encoder.matches(loginUsuario.get().getSenha(), usuario.get().getSenha())) {

				String auth = loginUsuario.get().getEmail() + ":" + loginUsuario.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));

				String authHeader = "Basic " + new String(encodedAuth);

				loginUsuario.get().setToken(authHeader);
				loginUsuario.get().setNome(usuario.get().getNome());

				return loginUsuario;
			}
		}
		return null;
	}

}
