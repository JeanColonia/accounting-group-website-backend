package com.grupocontable.website.service.Impl;

import com.grupocontable.website.model.CategoriaCurso;
import com.grupocontable.website.repository.CategoriaCursoRepository;
import com.grupocontable.website.service.CategoriaCursoService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoriaCursoServiceImp implements CategoriaCursoService {
    private final CategoriaCursoRepository categoriaCursoRepository;

    public CategoriaCursoServiceImp(CategoriaCursoRepository categoriaCursoRepository){
        this.categoriaCursoRepository = categoriaCursoRepository;
    }

    @Override
    public CategoriaCurso crearCategoriaCurso(CategoriaCurso categoriaCurso) {
        return categoriaCursoRepository.save(categoriaCurso);
    }

    @Override
    public CategoriaCurso actualizarCategoriaCurso(CategoriaCurso categoriaCurso) {
        return categoriaCursoRepository.save(categoriaCurso);
    }

    @Override
    public Set<CategoriaCurso> obtenerCategoriasCursos() {
        return new LinkedHashSet<>(categoriaCursoRepository.findAll());
    }

    @Override
    public CategoriaCurso obtenerCategoriaCurso(Integer idCategoriaCurso) {
        return categoriaCursoRepository.findById(idCategoriaCurso).get();
    }

    @Override
    public void eliminarCategoriaCurso(Integer idCategoriaCurso) {
        CategoriaCurso categoria = new CategoriaCurso();
        categoria.setIdCategoriaCurso(idCategoriaCurso);
        categoriaCursoRepository.delete(categoria);
    }
}
