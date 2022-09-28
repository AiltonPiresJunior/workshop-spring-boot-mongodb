package com.ailton.workshopmongo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<Usuario> findById(@PathVariable String id){
		Usuario usuario = usuarioService.findById(id);
		
		return ResponseEntity.ok().body(usuario);
	}
	
	@GetMapping(value="/email/{email}")
	public ResponseEntity<Usuario> findByEmail(@PathVariable String email){
		Usuario usuario = usuarioService.findByEmail(email);
		
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> cadastraUsuario(@RequestBody Usuario usuario){
		Usuario usuarioCriado = usuarioService.cadastraUsuario(usuario);
		
		return ResponseEntity.ok().body(usuarioCriado);
		
	}

	@DeleteMapping(value="/deletaTodos")
	public ResponseEntity<List<Usuario>> deletarTodosUsuarios(){

		return ResponseEntity.ok().body(usuarioService.deletaTodosUsarios());
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Usuario> deletaUsuario(@PathVariable String id){
		usuarioService.deletaUsuario(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Usuario> alteraUsuario(@PathVariable String id, @RequestBody Usuario usuario){
		
		Usuario usuarioAlterado = usuarioService.alteraUsuario(id, usuario);
		
		return ResponseEntity.ok().body(usuarioAlterado);
		
	}
	
}