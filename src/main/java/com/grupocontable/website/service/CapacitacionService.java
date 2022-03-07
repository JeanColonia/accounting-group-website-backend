package com.grupocontable.website.service;

import com.grupocontable.website.model.Capacitacion;
import com.grupocontable.website.repository.CapacitacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapacitacionService {
    private final CapacitacionRepository capacitacionRepository;

    public CapacitacionService(CapacitacionRepository capacitacionRepository) {
        this.capacitacionRepository = capacitacionRepository;
    }

    public List<Capacitacion> listar(){
        return capacitacionRepository.findAll();
    }

    public Capacitacion obtenerCapacitacion(Integer id){
        return capacitacionRepository.findById(id).get();
    }

    public void agregarCapacitacion(Capacitacion capacitacion){
        capacitacionRepository.save(capacitacion);
    }

    public void eliminarCapacitacion(Integer id){
        capacitacionRepository.deleteById(id);
    }
}
