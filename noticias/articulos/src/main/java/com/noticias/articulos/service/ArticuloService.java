package com.noticias.articulos.service;
import com.noticias.articulos.model.Articulo;
import com.noticias.articulos.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class ArticuloService {
	@Autowired private ArticuloRepository repository;
	public List<Articulo> findAll() { return repository.findAll(); }
	public Optional<Articulo> findById(String id) { return repository.findById(id); }
	public Articulo save(Articulo a) {
		if (a.getFecha() == null) a.setFecha(LocalDateTime.now());
		return repository.save(a);
	}
	public void deleteById(String id) { repository.deleteById(id); }
	public List<Articulo> findByCategoria(String id) { return repository.findByCategoriaId(id); }
	public List<Articulo> findByAutor(String id) { return repository.findByAutorId(id); }
}
