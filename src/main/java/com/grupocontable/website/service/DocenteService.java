package com.grupocontable.website.service;

import com.grupocontable.website.model.Docentes;
import com.grupocontable.website.repository.DocenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface DocenteService {

    Docentes crearDocente(Docentes docente);
    Docentes actualizarDocente(Docentes docente);
    Set<Docentes> obtenerDocentes();
    Docentes obtenerDocente(Integer idDocente);
    void eliminarDocente(Integer idDocente);
}
