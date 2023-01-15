package com.grupocontable.website.controllers;

import com.grupocontable.website.model.Evento;
import com.grupocontable.website.service.EventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("evento/api")
@CrossOrigin("*")
public class EventoController {

    private final EventoService eventoService;
    public EventoController(EventoService eventoService){
        this.eventoService = eventoService;
    }

    @PostMapping("/")
    public ResponseEntity<Evento> agregarEvento(@RequestBody Evento evento){
        Evento eventoSaved = eventoService.crearEvento(evento);
        return ResponseEntity.ok(eventoSaved);
    }


    @PutMapping("/")
    public Evento actualizarEvento(@RequestBody Evento evento) {
        return eventoService.actualizarEvento(evento);
    }

    @GetMapping("/")
    public ResponseEntity<?> obtenerEventos(){
        return ResponseEntity.ok(eventoService.obtenerEventos());
    }

    @GetMapping("/{idEvento}")
    public Evento obtenerEvento(@PathVariable("idEvento") Integer idEvento){
        return eventoService.obtenerEvento(idEvento);
    }

    @DeleteMapping("/{idEvento}")
    public void eliminarEvento(@PathVariable("idEvento") Integer idEvento){
        eventoService.eliminarEvento(idEvento);
    }
}
