package com.noticias.articulos.controller;
import com.noticias.articulos.model.Articulo;
import com.noticias.articulos.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/articulos")
@CrossOrigin(origins = "*")
public class ArticuloController {
	@Autowired private ArticuloService service;
	@GetMapping public List<Articulo> getAll() { return service.findAll(); }
	@GetMapping("/{id}") public ResponseEntity<Articulo> getById(@PathVariable String id) {
		return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	@PostMapping public Articulo create(@RequestBody Articulo a) { return service.save(a); }
	@PutMapping("/{id}") public ResponseEntity<Articulo> update(@PathVariable String id, @RequestBody Articulo a) {
		return service.findById(id).map(e -> { a.setId(id); return ResponseEntity.ok(service.save(a)); })
				.orElse(ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable String id) {
		service.deleteById(id); return ResponseEntity.noContent().build();
	}
	@GetMapping("/categoria/{id}") public List<Articulo> byCategoria(@PathVariable String id) { return service.findByCategoria(id); }
	@GetMapping("/autor/{id}") public List<Articulo> byAutor(@PathVariable String id) { return service.findByAutor(id); }
}
