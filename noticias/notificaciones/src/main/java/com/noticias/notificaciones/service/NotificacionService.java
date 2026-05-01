package com.noticias.notificaciones.service;

import com.noticias.notificaciones.model.Notificacion;
import com.noticias.notificaciones.repository.NotificacionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacionService {

    private final NotificacionRepository repository;

    public NotificacionService(NotificacionRepository repository) {
        this.repository = repository;
    }

    // Listar ordenado por fecha (más reciente primero)
    public List<Notificacion> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "fecha"));
    }

    // Guardar notificación
    public Notificacion save(Notificacion n) {

        if (n.getFecha() == null) {
            n.setFecha(LocalDateTime.now());
        }

        if (n.getLeido() == null) {
            n.setLeido(false);
        }

        if (n.getAlerta() == null || n.getAlerta().isEmpty()) {
            n.setAlerta("Sin mensaje");
        }

        if (n.getUsuarioId() == null || n.getUsuarioId().isBlank()) {
            n.setUsuarioId("Anónimo");
        }

        return repository.save(n);
    }

    // Eliminar por ID
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}