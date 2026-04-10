package com.noticias.notificaciones.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
@Document(collection = "notificaciones")
public class Notificacion {
	@Id private String id;
	private String alerta;
	private String usuarioId;
	private LocalDateTime fecha;
	private Boolean leido;
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getAlerta() { return alerta; }
	public void setAlerta(String alerta) { this.alerta = alerta; }
	public String getUsuarioId() { return usuarioId; }
	public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
	public LocalDateTime getFecha() { return fecha; }
	public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
	public Boolean getLeido() { return leido; }
	public void setLeido(Boolean leido) { this.leido = leido; }
}
