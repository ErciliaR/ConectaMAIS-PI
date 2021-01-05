package com.GrupoConecta.ConectaMais.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.GrupoConecta.ConectaMais.model.Usuario;
import com.GrupoConecta.ConectaMais.repository.UsuarioRepositorio;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepositorio.findByEmail(email);
		usuario.orElseThrow(() -> new UsernameNotFoundException(email + "not found."));
		return usuario.map(userDetailsImpl::new).get();
	}
}
