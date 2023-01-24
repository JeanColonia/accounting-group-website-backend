package com.grupocontable.website.service;

import com.grupocontable.website.model.Membresia;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface MembresiaService {

    Membresia crearMembresia(Membresia membresia);
    Membresia actualizarMembresia(Membresia membresia);
    Set<Membresia> listarMembresias();
    Membresia obtenerMembresia(Integer idMembresia);

    void eliminarMembresia(Integer idMembresia);
}
