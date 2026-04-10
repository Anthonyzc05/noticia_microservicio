package com.noticias.categorias.controller;
import com.noticias.categorias.model.Categoria;
import com.noticias.categorias.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {
	@Autowired private CategoriaService service;
	@GetMapping public List<Categoria> getAll() { return service.findAll(); }
	@GetMapping("/{id}") public ResponseEntity<Categoria> getById(@PathVariable String id) {
		return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	@PostMapping public Categoria create(@RequestBody Categoria c) { return service.save(c); }
	@PutMapping("/{id}") public ResponseEntity<Categoria> update(@PathVariable String id, @RequestBody Categoria c) {
		return service.findById(id).map(e -> { c.setId(id); return ResponseEntity.ok(service.save(c)); }).orElse(ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable String id) {
		service.deleteById(id); return ResponseEntity.noContent().build();
	}
}
