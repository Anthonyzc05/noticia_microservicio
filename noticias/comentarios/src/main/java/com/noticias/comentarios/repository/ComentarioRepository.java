package com.noticias.comentarios.repository;
import com.noticias.comentarios.model.Comentario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ComentarioRepository extends MongoRepository<Comentario, String> {
	List<Comentario> findByArticuloId(String articuloId);
}
