package com.ailton.workshopmongo.service.impl;

import java.util.List;
import java.util.Optional;

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

	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND,ErrorsEnum.NAO_ENCONTROU));
	}

	public Usuario cadastraUsuario(Usuario usuario) {
		Optional<Usuario> validacao = usuarioRepository.findByEmail(usuario.getEmail());
		if(validacao.isEmpty()) {
			return usuarioRepository.save(usuario);
		}
		throw new BusinessException(HttpStatus.CONFLICT,ErrorsEnum.EMAIL_CADASTRADO) ;
	}

	public List<Usuario> deletaTodosUsarios() {
		List<Usuario> usuarios = findAll();
		
		for( Usuario usuario : usuarios) {
			usuarioRepository.delete(usuario);
		}
		
		return usuarios;
	}

	public Usuario deletaUsuario(String id) {
		Usuario usuario = findById(id);
		usuarioRepository.delete(usuario);
		
		return usuario;
	}

	public Usuario alteraUsuario(String id, Usuario usuario) {
		Usuario usuarioBanco = findById(id);
		
		usuarioBanco.setName(usuario.getName());
		usuarioBanco.setEmail(usuario.getEmail());
		
		usuarioRepository.save(usuarioBanco);
		
		return usuarioBanco;
	}


}