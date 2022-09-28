package com.ailton.workshopmongo.service;

import java.util.List;

import com.ailton.workshopmongo.domain.Usuario;

public interface UsuarioService {
	
	List<Usuario> findAll() ;
	
	Usuario findById(String id);

	Usuario cadastraUsuario(Usuario usuario);

	Usuario findByEmail(String email);

	List<Usuario> deletaTodosUsarios();

	Usuario deletaUsuario(String id);

	Usuario alteraUsuario(String id, Usuario usuario);
}
