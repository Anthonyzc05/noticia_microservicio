package com.noticias.favoritos.controller;
import com.noticias.favoritos.model.Favorito;
import com.noticias.favoritos.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/favoritos")
@CrossOrigin(origins = "*")
public class FavoritoController {
	@Autowired private FavoritoService service;
	@GetMapping public List<Favorito> getAll() { return service.findAll(); }
	@GetMapping("/{id}") public ResponseEntity<Favorito> getById(@PathVariable String id) {
		return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	@PostMapping public Favorito create(@RequestBody Favorito f) { return service.save(f); }
	@DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable String id) {
		service.deleteById(id); return ResponseEntity.noContent().build();
	}
	@GetMapping("/usuario/{id}") public List<Favorito> byUsuario(@PathVariable String id) { return service.findByUsuario(id); }
}
