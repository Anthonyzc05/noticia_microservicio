package com.noticias.reacciones.repository;
import com.noticias.reacciones.model.Reaccion;
import com.noticias.reacciones.model.TipoReaccion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ReaccionRepository extends MongoRepository<Reaccion, String> {
	List<Reaccion> findByArticuloId(String articuloId);
	long countByArticuloIdAndTipo(String articuloId, TipoReaccion tipo);
}
