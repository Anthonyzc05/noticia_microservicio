package com.noticias.comentarios.controller;
import com.noticias.comentarios.model.Comentario;
import com.noticias.comentarios.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin(origins = "*")
public class ComentarioController {
	@Autowired private ComentarioService service;
	@GetMapping public List<Comentario> getAll() { return service.findAll(); }
	@GetMapping("/{id}") public ResponseEntity<Comentario> getById(@PathVariable String id) {
		return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	@PostMapping public Comentario create(@RequestBody Comentario c) { return service.save(c); }
	@DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable String id) {
		service.deleteById(id); return ResponseEntity.noContent().build();
	}
	@GetMapping("/articulo/{id}") public List<Comentario> byArticulo(@PathVariable String id) {
		return service.findByArticulo(id);
	}
}
