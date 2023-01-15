package com.grupocontable.website.service;

import com.grupocontable.website.model.Evento;
import com.grupocontable.website.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface EventoService {

    Evento crearEvento(Evento evento);
    Evento actualizarEvento(Evento evento);
    Set<Evento> obtenerEventos();
    Evento obtenerEvento(Integer idEvento);
    void eliminarEvento(Integer idEvento);
}
