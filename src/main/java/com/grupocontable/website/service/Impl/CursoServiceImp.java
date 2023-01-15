package com.grupocontable.website.service.Impl;

import com.grupocontable.website.model.Curso;
import com.grupocontable.website.repository.CursoRepository;
import com.grupocontable.website.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;


@Service
public class CursoServiceImp implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImp(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

     @Override
    public Curso agregarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso actualizarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Set<Curso> obtenerCursos() {
        return new LinkedHashSet<>(cursoRepository.findAll());
    }

    @Override
    public Curso obtenerCurso(Integer cursoId) {
        return cursoRepository.findById(cursoId).get();
    }

    @Override
    public void eliminarCurso(Integer cursoId) {
        Curso curso = new Curso();
        curso.setIdCurso(cursoId);
        cursoRepository.delete(curso);
    }
}
