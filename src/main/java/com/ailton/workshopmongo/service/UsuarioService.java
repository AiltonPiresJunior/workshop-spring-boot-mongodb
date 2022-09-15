package com.ailton.workshopmongo.service;

import java.util.List;

import com.ailton.workshopmongo.domain.Usuario;

public interface UsuarioService {
	
	List<Usuario> findAll() ;

	Usuario findById(Long id);

	
}
