package com.noticias.usuarios.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
@Document(collection = "usuarios")
public class Usuario {
	@Id private String id;
	private String nombre;
	@Indexed(unique = true)
	private String email;
	private String contrasena;
	private String rol;
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getContrasena() { return contrasena; }
	public void setContrasena(String contrasena) { this.contrasena = contrasena; }
	public String getRol() { return rol; }
	public void setRol(String rol) { this.rol = rol; }
}
