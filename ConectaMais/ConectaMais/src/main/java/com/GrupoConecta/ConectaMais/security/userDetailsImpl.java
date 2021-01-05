package com.GrupoConecta.ConectaMais.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.GrupoConecta.ConectaMais.model.Usuario;

public class userDetailsImpl implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	/* atributos */
	private String email;
	
	private String senha;
	
	/* construtores */
	public userDetailsImpl(Usuario usuario) {
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}
	
	public userDetailsImpl() {
		
	}
	
	/* métodos */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
