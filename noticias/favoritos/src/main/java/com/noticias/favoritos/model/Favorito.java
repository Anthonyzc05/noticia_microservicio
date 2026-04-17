package com.noticias.favoritos.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
@Document(collection = "favoritos")
public class Favorito {
	@Id private String id;
	private String usuarioId;
	private String articuloId;
	private LocalDateTime fecha;
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getUsuarioId() { return usuarioId; }
	public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
	public String getArticuloId() { return articuloId; }
	public void setArticuloId(String articuloId) { this.articuloId = articuloId; }
	public LocalDateTime getFecha() { return fecha; }
	public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}
