package com.noticias.usuarios.controller;

import com.noticias.usuarios.model.Usuario;
import com.noticias.usuarios.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class VistaController {

    @Autowired
    private UsuarioService service;

    //  MOSTRAR LISTA
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", service.findAll());
        return "usuario"; 
    }

    //  ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/usuarios";
    }
}