package com.noticias.reacciones.controller;

import com.noticias.reacciones.model.Reaccion;
import com.noticias.reacciones.model.TipoReaccion;
import com.noticias.reacciones.service.ReaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reacciones")
public class VistaController {

    @Autowired
    private ReaccionService service;

   
    @GetMapping
    public String verTodo(Model model) {

        String articuloId = "1"; 

        
        model.addAttribute("reacciones", service.findAll());

      
        model.addAttribute("articuloId", articuloId);
        model.addAttribute("likes", service.countLikes(articuloId));
        model.addAttribute("dislikes", service.countDislikes(articuloId));

        return "reacciones/reacciones";
    }

    
    @PostMapping("/guardar")
    public String reaccionar(@RequestParam String tipo,
                            @RequestParam String articuloId) {

        Reaccion r = new Reaccion();
        r.setArticuloId(articuloId);

        
        r.setTipo(TipoReaccion.valueOf(tipo.toUpperCase()));

        service.save(r);

        return "redirect:/reacciones";
    }

    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {

        service.deleteById(id);

        return "redirect:/reacciones";
    }
}