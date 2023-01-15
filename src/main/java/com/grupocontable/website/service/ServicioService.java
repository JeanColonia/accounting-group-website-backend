package com.grupocontable.website.service;

import com.grupocontable.website.model.Servicio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface ServicioService {

    Servicio crearServicio(Servicio servicio);
    Servicio actualizarServicio(Servicio servicio);
    Set<Servicio> obtenerServicios();
    Servicio obtenerServicio(Integer idServicio);
    void eliminarServicio(Integer idServicio);
}
