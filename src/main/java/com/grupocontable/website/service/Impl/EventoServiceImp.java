package com.grupocontable.website.service.Impl;

import com.grupocontable.website.model.Evento;
import com.grupocontable.website.repository.EventoRepository;
import com.grupocontable.website.service.EventoService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class EventoServiceImp implements EventoService {

    private final EventoRepository eventoRepository;
    public EventoServiceImp(EventoRepository eventoRepository){
        this.eventoRepository= eventoRepository;
    }
    @Override
    public Evento crearEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public Evento actualizarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public Set<Evento> obtenerEventos() {
        return new LinkedHashSet<>(eventoRepository.findAll());
    }

    @Override
    public Evento obtenerEvento(Integer idEvento) {
        return eventoRepository.findById(idEvento).get();
    }

    @Override
    public void eliminarEvento(Integer idEvento) {
    Evento evento = new Evento();
    evento.setIdEvento(idEvento);
    eventoRepository.delete(evento);
    }
}
