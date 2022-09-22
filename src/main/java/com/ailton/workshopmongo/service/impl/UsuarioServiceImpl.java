package com.ailton.workshopmongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ailton.workshopmongo.domain.Usuario;
import com.ailton.workshopmongo.exception.BusinessException;
import com.ailton.workshopmongo.exception.ErrorsEnum;
import com.ailton.workshopmongo.repository.UsuarioRepository;
import com.ailton.workshopmongo.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}


	public Usuario findById(String id) {

		return usuarioRepository.findById(id).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND,ErrorsEnum.NAO_ENCONTROU));
	}

}
