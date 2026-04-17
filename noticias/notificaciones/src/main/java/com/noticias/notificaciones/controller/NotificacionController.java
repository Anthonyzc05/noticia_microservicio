package com.noticias.notificaciones.controller;

import com.noticias.notificaciones.model.Notificacion;
import com.noticias.notificaciones.service.NotificacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    //  Obtener tods las notificaciones
    @GetMapping
    public List<Notificacion> obtenerTodas() {
        return notificacionService.findAll();
    }

    //  Gurdar una notificación
    @PostMapping
    public Notificacion guardar(@RequestBody Notificacion n) {
        return notificacionService.save(n);
    }

    // 
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        notificacionService.deleteById(id);
    }
}