package com.noticias.comentarios.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/formulario")
public class vistacontroller {

    private List<Comentario> listaComentarios = new ArrayList<>();
    private Long contador = 1L;

    // 🔹 Mostrar página
    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("comentario", new Comentario());
        model.addAttribute("listaComentarios", listaComentarios);
        return "comentarios/formulario"; // importante por tu carpeta
    }

    // 🔹 Guardar comentario
    @PostMapping("/guardar")
    public String guardarComentario(@ModelAttribute Comentario comentario) {
        comentario.setId(contador++);
        listaComentarios.add(comentario);
        return "redirect:/comentarios";
    }

    // 🔹 Eliminar comentario
    @GetMapping("/eliminar/{id}")
    public String eliminarComentario(@PathVariable Long id) {
        listaComentarios.removeIf(c -> c.getId().equals(id));
        return "redirect:/comentarios";
    }

    // 🔹 Clase interna
    public static class Comentario {
        private Long id;
        private String comentario;
        private Long usuarioId;
        private Long articuloId;
        private String fecha;

        public Comentario() {}

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getComentario() { return comentario; }
        public void setComentario(String comentario) { this.comentario = comentario; }

        public Long getUsuarioId() { return usuarioId; }
        public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

        public Long getArticuloId() { return articuloId; }
        public void setArticuloId(Long articuloId) { this.articuloId = articuloId; }

        public String getFecha() { return fecha; }
        public void setFecha(String fecha) { this.fecha = fecha; }
    }
}