package com.noticias.reacciones.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "reacciones")
public class Reaccion {
	@Id private String id;
	private String usuarioId;
	private String articuloId;
	private TipoReaccion tipo;
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getUsuarioId() { return usuarioId; }
	public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
	public String getArticuloId() { return articuloId; }
	public void setArticuloId(String articuloId) { this.articuloId = articuloId; }
	public TipoReaccion getTipo() { return tipo; }
	public void setTipo(TipoReaccion tipo) { this.tipo = tipo; }
}
