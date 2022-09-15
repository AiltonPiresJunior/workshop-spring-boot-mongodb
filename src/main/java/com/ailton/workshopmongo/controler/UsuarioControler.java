package com.ailton.workshopmongo.controler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ailton.workshopmongo.domain.Usuario;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioControler {
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		Usuario maria = new Usuario("1", "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario("2", "Alex Green", "alex@gmail.com");
		
		List<Usuario> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(list);
	}

}
