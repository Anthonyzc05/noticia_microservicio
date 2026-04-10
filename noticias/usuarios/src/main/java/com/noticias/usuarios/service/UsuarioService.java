package com.noticias.usuarios.service;
import com.noticias.usuarios.model.Usuario;
import com.noticias.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {
	@Autowired private UsuarioRepository repository;
	public List<Usuario> findAll() { return repository.findAll(); }
	public Optional<Usuario> findById(String id) { return repository.findById(id); }
	public Usuario save(Usuario u) { return repository.save(u); }
	public void deleteById(String id) { repository.deleteById(id); }
	public Optional<Usuario> findByEmail(String email) { return repository.findByEmail(email); }
}
