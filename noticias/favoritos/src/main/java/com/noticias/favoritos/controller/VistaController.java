package com.noticias.favoritos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.noticias.favoritos.service.FavoritoService;

@Controller
public class VistaController {

    @Autowired
    private FavoritoService service;

    // LISTAR
    @GetMapping("/lista")
    public String verLista(Model model) {
        model.addAttribute("favoritos", service.findAll());
        return "lista";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/lista";
    }
}