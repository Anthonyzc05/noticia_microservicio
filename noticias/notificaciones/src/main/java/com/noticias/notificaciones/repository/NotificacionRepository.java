package com.noticias.notificaciones.repository;
import com.noticias.notificaciones.model.Notificacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface NotificacionRepository extends MongoRepository<Notificacion, String> {
	List<Notificacion> findByUsuarioId(String usuarioId);
	List<Notificacion> findByUsuarioIdAndLeido(String usuarioId, Boolean leido);
}
