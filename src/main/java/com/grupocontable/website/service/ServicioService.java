package com.grupocontable.website.service;

import com.grupocontable.website.model.Servicio;
import com.grupocontable.website.repository.ServicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {
    private final ServicioRepository servicioRepository;


    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public List<Servicio> listar(){
        return servicioRepository.findAll();
    }

    public Servicio obtenerServicio(Integer id){
        return servicioRepository.findById(id).get();
    }

    public void agregarServicio(Servicio servicio){
        servicioRepository.save(servicio);
    }

    public void eliminarServicio(Integer id){
        servicioRepository.deleteById(id);
    }
}
