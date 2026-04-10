package com.noticias.reacciones.service;
import com.noticias.reacciones.model.Reaccion;
import com.noticias.reacciones.model.TipoReaccion;
import com.noticias.reacciones.repository.ReaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ReaccionService {
	@Autowired private ReaccionRepository repository;
	public List<Reaccion> findAll() { return repository.findAll(); }
	public Optional<Reaccion> findById(String id) { return repository.findById(id); }
	public Reaccion save(Reaccion r) { return repository.save(r); }
	public void deleteById(String id) { repository.deleteById(id); }
	public List<Reaccion> findByArticulo(String id) { return repository.findByArticuloId(id); }
	public long countLikes(String id) { return repository.countByArticuloIdAndTipo(id, TipoReaccion.LIKE); }
	public long countDislikes(String id) { return repository.countByArticuloIdAndTipo(id, TipoReaccion.DISLIKE); }
}
