package com.grupocontable.website.service;

import com.grupocontable.website.model.Curso;
import com.grupocontable.website.model.Temario;
import com.grupocontable.website.repository.TemarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface TemarioService {

    Temario crearTemario(Temario temario);
    Temario actualizarTemario(Temario temario);
    Set<Temario> obtenerTemarios();
    Temario obtenerTemario(Integer idTemario);
    void eliminarTemario(Integer idTemario);
    Set<Temario> obtenerTemarioDelCurso(Curso curso);



}
