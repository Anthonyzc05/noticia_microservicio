package com.noticias.comentarios.service;
import com.noticias.comentarios.model.Comentario;
import com.noticias.comentarios.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class ComentarioService {
	@Autowired private ComentarioRepository repository;
	public List<Comentario> findAll() { return repository.findAll(); }
	public Optional<Comentario> findById(String id) { return repository.findById(id); }
	public Comentario save(Comentario c) {
		if (c.getFecha() == null) c.setFecha(LocalDateTime.now());
		return repository.save(c);
	}
	public void deleteById(String id) { repository.deleteById(id); }
	public List<Comentario> findByArticulo(String id) { return repository.findByArticuloId(id); }
}
