package com.ailton.workshopmongo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ailton.workshopmongo.domain.Usuario;
import com.ailton.workshopmongo.service.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioControler {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> usuario = usuarioService.findAll();
		
		return ResponseEntity.ok().body(usuario);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Usuario> findById(Long id){
		Usuario usuario = usuarioService.findById(id);
		
	}
}
