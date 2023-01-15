package com.grupocontable.website.service.Impl;

import com.grupocontable.website.model.Servicio;
import com.grupocontable.website.repository.ServicioRepository;
import com.grupocontable.website.service.ServicioService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class ServicioServiceImp implements ServicioService {
    private final ServicioRepository servicioRepository;

    public ServicioServiceImp(ServicioRepository servicioRepository){
        this.servicioRepository = servicioRepository;
    }

    @Override
    public Servicio crearServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio actualizarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public Set<Servicio> obtenerServicios() {
        return new LinkedHashSet<>(servicioRepository.findAll());
    }

    @Override
    public Servicio obtenerServicio(Integer idServicio) {
        return servicioRepository.findById(idServicio).get();
    }

    @Override
    public void eliminarServicio(Integer idServicio) {
    Servicio servicio = new Servicio();
    servicio.setIdServicio(idServicio);
    servicioRepository.delete(servicio);
    }
}
