package com.grupocontable.website.service;


import com.grupocontable.website.model.Modalidad;

import java.util.Set;

public interface ModalidadService {

    Modalidad crearModalidad(Modalidad modalidad);
    Modalidad actualizarModalidad(Modalidad modalidad);
    Set<Modalidad> obtenerModalidades();
    Modalidad obtenerModalidad(Integer idModalidad);
    void eliminarModalidad(Integer idModalidad);
}
