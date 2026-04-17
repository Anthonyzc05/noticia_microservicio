package com.noticias.notificaciones.service;

import com.noticias.notificaciones.model.Notificacion;
import com.noticias.notificaciones.repository.NotificacionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacionService {

    private final NotificacionRepository repository;

    public NotificacionService(NotificacionRepository repository) {
        this.repository = repository;
    }

    // 
    public List<Notificacion> findAll() {
        return repository.findAll();
    }

    // 
    public Notificacion save(Notificacion n) {
        if (n.getFecha() == null) {
            n.setFecha(LocalDateTime.now().toString());
        }
        return repository.save(n);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}