package com.ailton.workshopmongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ailton.workshopmongo.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	
}
