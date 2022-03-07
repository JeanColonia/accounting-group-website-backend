package com.grupocontable.website.controllers;

import com.grupocontable.website.model.Evento;
import com.grupocontable.website.service.EventoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("evento/api")
public class EventoController {
private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping("/listar")
    public List<Evento> listar(){
        return eventoService.listar();
    }


}
