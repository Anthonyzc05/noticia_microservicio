package com.noticias.notificaciones.service;
import com.noticias.notificaciones.model.Notificacion;
import com.noticias.notificaciones.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class NotificacionService {
	@Autowired private NotificacionRepository repository;
	public List<Notificacion> findAll() { return repository.findAll(); }
	public Optional<Notificacion> findById(String id) { return repository.findById(id); }
	public Notificacion save(Notificacion n) {
		if (n.getFecha() == null) n.setFecha(LocalDateTime.now());
		if (n.getLeido() == null) n.setLeido(false);
		return repository.save(n);
	}
	public void deleteById(String id) { repository.deleteById(id); }
	public List<Notificacion> findByUsuario(String id) { return repository.findByUsuarioId(id); }
	public List<Notificacion> findNoLeidas(String id) { return repository.findByUsuarioIdAndLeido(id, false); }
}
