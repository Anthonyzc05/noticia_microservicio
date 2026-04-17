package com.noticias.articulos.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
@Document(collection = "articulos")
public class Articulo {
	@Id
	private String id;
	private String titulo;
	private String contenido;
	private String autorId;
	private String categoriaId;
	private LocalDateTime fecha;
	private Boolean publicacion;
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }
	public String getContenido() { return contenido; }
	public void setContenido(String contenido) { this.contenido = contenido; }
	public String getAutorId() { return autorId; }
	public void setAutorId(String autorId) { this.autorId = autorId; }
	public String getCategoriaId() { return categoriaId; }
	public void setCategoriaId(String categoriaId) { this.categoriaId = categoriaId; }
	public LocalDateTime getFecha() { return fecha; }
	public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
	public Boolean getPublicacion() { return publicacion; }
	public void setPublicacion(Boolean publicacion) { this.publicacion = publicacion; }
}
