package com.noticias.favoritos.service;
import com.noticias.favoritos.model.Favorito;
import com.noticias.favoritos.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class FavoritoService {
	@Autowired private FavoritoRepository repository;
	public List<Favorito> findAll() { return repository.findAll(); }
	public Optional<Favorito> findById(String id) { return repository.findById(id); }
	public Favorito save(Favorito f) {
		if (f.getFecha() == null) f.setFecha(LocalDateTime.now());
		return repository.save(f);
	}
	public void deleteById(String id) { repository.deleteById(id); }
	public List<Favorito> findByUsuario(String id) { return repository.findByUsuarioId(id); }
}
