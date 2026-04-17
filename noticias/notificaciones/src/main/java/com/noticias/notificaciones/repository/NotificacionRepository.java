package com.noticias.notificaciones.repository;
import com.noticias.notificaciones.model.Notificacion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificacionRepository extends MongoRepository<Notificacion, String> {
}
