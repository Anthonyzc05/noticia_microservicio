package com.noticias.categorias.service;
import com.noticias.categorias.model.Categoria;
import com.noticias.categorias.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CategoriaService {
	@Autowired private CategoriaRepository repository;
	public List<Categoria> findAll() { return repository.findAll(); }
	public Optional<Categoria> findById(String id) { return repository.findById(id); }
	public Categoria save(Categoria c) { return repository.save(c); }
	public void deleteById(String id) { repository.deleteById(id); }
}
