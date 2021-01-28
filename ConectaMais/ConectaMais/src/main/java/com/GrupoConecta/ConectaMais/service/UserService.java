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
		if(usuarioPresente.isPresent()) {
			return null; // verificando se o email já existe. Se sim, retorne vazio
		}

		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder); // se não, o backend pega a senha e encriptografa

		return usuarioRepositorio.save(usuario); // esse conversa com o controlador a fim de indicar a presença ou nao do usuario no sistema
	}

	public Optional<LoginUsuario> Logar(Optional<LoginUsuario> loginUsuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = usuarioRepositorio.findByEmail(loginUsuario.get().getEmail());

		if (usuario.isPresent()) {
			if (encoder.matches(loginUsuario.get().getSenha(), usuario.get().getSenha())) {

				String auth = loginUsuario.get().getEmail() + ":" + loginUsuario.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));

				String authHeader = "Basic " + new String(encodedAuth);

				loginUsuario.get().setToken(authHeader);
				loginUsuario.get().setId(usuario.get().getUsuarioID());
				loginUsuario.get().setNome(usuario.get().getNome());
				loginUsuario.get().setImagemPerfilURL(usuario.get().getImagemPerfilURL());
				loginUsuario.get().setPapel(usuario.get().getPapel());

				return loginUsuario;
			} // checa se o usuario existe e se a senha adicionada bate com a armazenada no banco. Tudo encriptografado!
		}
		return null;
	}

}
