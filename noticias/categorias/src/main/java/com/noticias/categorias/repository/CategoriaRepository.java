package com.noticias.categorias.repository;
import com.noticias.categorias.model.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String> {}
