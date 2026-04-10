package com.noticias.articulos.repository;
import com.noticias.articulos.model.Articulo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ArticuloRepository extends MongoRepository<Articulo, String> {
	List<Articulo> findByCategoriaId(String categoriaId);
	List<Articulo> findByAutorId(String autorId);
	List<Articulo> findByPublicacion(Boolean publicacion);
}
