package com.noticias.usuarios.repository;
import com.noticias.usuarios.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	Optional<Usuario> findByEmail(String email);
}
