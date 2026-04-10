package com.noticias.notificaciones.controller;
import com.noticias.notificaciones.model.Notificacion;
import com.noticias.notificaciones.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/notificaciones")
@CrossOrigin(origins = "*")
public class NotificacionController {
	@Autowired private NotificacionService service;
	@GetMapping public List<Notificacion> getAll() { return service.findAll(); }
	@GetMapping("/{id}") public ResponseEntity<Notificacion> getById(@PathVariable String id) {
		return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	@PostMapping public Notificacion create(@RequestBody Notificacion n) { return service.save(n); }
	@DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable String id) {
		service.deleteById(id); return ResponseEntity.noContent().build();
	}
	@GetMapping("/usuario/{id}") public List<Notificacion> byUsuario(@PathVariable String id) { return service.findByUsuario(id); }
	@GetMapping("/usuario/{id}/noleidas") public List<Notificacion> noLeidas(@PathVariable String id) { return service.findNoLeidas(id); }
}
