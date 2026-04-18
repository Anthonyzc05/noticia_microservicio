package com.noticias.articulos.controller;

import com.noticias.articulos.model.Articulo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class articuloscontroller {

    @GetMapping("/articulos")
    public String mostrarVistaArticulos(Model model) {

        List<Articulo> lista = new ArrayList<>();

        Articulo a1 = new Articulo();
        a1.setId("1");
        a1.setTitulo("La inteligencia artificial en el periodismo");
        a1.setContenido("La IA está transformando la manera en que se crea y distribuye la información.");
        a1.setAutorId("AUT001");
        a1.setCategoriaId("CAT001");
        a1.setFecha(LocalDateTime.now());
        a1.setPublicacion(true);

        Articulo a2 = new Articulo();
        a2.setId("2");
        a2.setTitulo("Microservicios en aplicaciones modernas");
        a2.setContenido("Los microservicios permiten dividir sistemas complejos en módulos independientes.");
        a2.setAutorId("AUT002");
        a2.setCategoriaId("CAT002");
        a2.setFecha(LocalDateTime.now());
        a2.setPublicacion(false);

        lista.add(a1);
        lista.add(a2);

        model.addAttribute("tituloPagina", "Microservicio de Artículos");
        model.addAttribute("subtitulo", "Gestión visual de artículos");
        model.addAttribute("articulos", lista);

        return "articulos/articulos";
    }
}