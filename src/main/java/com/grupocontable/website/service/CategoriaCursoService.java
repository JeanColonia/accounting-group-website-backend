package com.grupocontable.website.service;

import com.grupocontable.website.model.CategoriaCurso;

import java.util.Set;

public interface CategoriaCursoService {
    CategoriaCurso crearCategoriaCurso(CategoriaCurso categoriaCurso);
    CategoriaCurso actualizarCategoriaCurso(CategoriaCurso categoriaCurso);
    Set<CategoriaCurso> obtenerCategoriasCursos();
    CategoriaCurso obtenerCategoriaCurso(Integer idCategoriaCurso);
    void eliminarCategoriaCurso(Integer idCategoriaCurso);

}
