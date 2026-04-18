package com.noticias.articulos.controller;

import com.noticias.articulos.model.Articulo;
import com.noticias.articulos.service.ArticuloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articulos")
public class articuloscontroller {

    @Autowired
    private ArticuloService service;

    // 🔹 LISTAR + FORMULARIO
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("articulo", new Articulo());
        model.addAttribute("articulos", service.findAll());
        return "articulos/articulos"; // 👈 importante por carpeta
    }

    // 🔹 GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Articulo articulo) {
        service.save(articulo);
        return "redirect:/articulos";
    }

    // 🔹 ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/articulos";
    }
}