package com.noticias.categorias.controller;

import com.noticias.categorias.model.Categoria;
import com.noticias.categorias.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias") 
public class VistaController {

    @Autowired
    private CategoriaService service;

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", service.findAll());
        return "categorias/lista";
    }

    // FORMULARIO NUEVO
    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/formulario";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Categoria categoria) {
        service.save(categoria);
        return "redirect:/categorias"; 
    }
}