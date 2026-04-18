package com.noticias.comentarios.controller;

import com.noticias.comentarios.model.Comentario;
import com.noticias.comentarios.service.ComentarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comentarios")
public class vistacontroller {

    @Autowired
    private ComentarioService service;

    // 🔹 MOSTRAR HTML
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("comentario", new Comentario());
        model.addAttribute("comentarios", service.findAll());

        // 👇 IMPORTANTE (por tu carpeta)
        return "comentarios/formulario";
    }

    // 🔹 GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Comentario comentario) {
        service.save(comentario);
        return "redirect:/comentarios";
    }

    // 🔹 ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/comentarios";
    }
}