package com.noticias.favoritos.repository;
import com.noticias.favoritos.model.Favorito;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface FavoritoRepository extends MongoRepository<Favorito, String> {
	List<Favorito> findByUsuarioId(String usuarioId);
}
