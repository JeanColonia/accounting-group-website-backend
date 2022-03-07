package com.grupocontable.website.service;

import com.grupocontable.website.model.Evento;
import com.grupocontable.website.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> listar(){
        return eventoRepository.findAll();
    }

    public Evento obtenerEvento(Integer idEvento){
        return eventoRepository.findById(idEvento).get();
    }

    public void agregarEvento(Evento evento){
        eventoRepository.save(evento);
    }

    public void eliminarEvento(Integer idEvento){
        eventoRepository.deleteById(idEvento);
    }
}
