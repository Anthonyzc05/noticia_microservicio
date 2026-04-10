package com.noticias.reacciones.controller;
import com.noticias.reacciones.model.Reaccion;
import com.noticias.reacciones.service.ReaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/reacciones")
@CrossOrigin(origins = "*")
public class ReaccionController {
	@Autowired private ReaccionService service;
	@GetMapping public List<Reaccion> getAll() { return service.findAll(); }
	@GetMapping("/{id}") public ResponseEntity<Reaccion> getById(@PathVariable String id) {
		return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	@PostMapping public Reaccion create(@RequestBody Reaccion r) { return service.save(r); }
	@DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable String id) {
		service.deleteById(id); return ResponseEntity.noContent().build();
	}
	@GetMapping("/articulo/{id}") public List<Reaccion> byArticulo(@PathVariable String id) { return service.findByArticulo(id); }
	@GetMapping("/articulo/{id}/conteo") public Map<String, Long> conteo(@PathVariable String id) {
		return Map.of("likes", service.countLikes(id), "dislikes", service.countDislikes(id));
	}
}
