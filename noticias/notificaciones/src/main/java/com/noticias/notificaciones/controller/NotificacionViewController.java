package com.noticias.notificaciones.controller;

import com.noticias.notificaciones.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notificaciones")
public class NotificacionViewController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public String listar(Model model) {

        var lista = notificacionService.findAll();

        System.out.println("SIZE = " + lista.size());
        System.out.println("DATA = " + lista);

        model.addAttribute("notificaciones", lista);

        return "notificaciones";
    }
}