package com.noticias.usuarios.controller;
import com.noticias.usuarios.model.Usuario;
import com.noticias.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
	@Autowired private UsuarioService service;
	@GetMapping public List<Usuario> getAll() { return service.findAll(); }
	@GetMapping("/{id}") public ResponseEntity<Usuario> getById(@PathVariable String id) {
		return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	@PostMapping public Usuario create(@RequestBody Usuario u) { return service.save(u); }
	@PutMapping("/{id}") public ResponseEntity<Usuario> update(@PathVariable String id, @RequestBody Usuario u) {
		return service.findById(id).map(e -> { u.setId(id); return ResponseEntity.ok(service.save(u)); }).orElse(ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable String id) {
		service.deleteById(id); return ResponseEntity.noContent().build();
	}
}
