package com.grupocontable.website.service.Impl;

import com.grupocontable.website.model.Curso;
import com.grupocontable.website.model.Temario;
import com.grupocontable.website.repository.CursoRepository;
import com.grupocontable.website.repository.TemarioRepository;
import com.grupocontable.website.service.TemarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class TemarioServiceImp implements TemarioService {

    private final TemarioRepository temarioRepository;
    private final CursoRepository cursoRepository;

    public TemarioServiceImp(TemarioRepository temarioRepository, CursoRepository cursoRepository) {
        this.temarioRepository = temarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Temario crearTemario(Temario temario) {
        return temarioRepository.save(temario);
    }

    @Override
    public Temario actualizarTemario(Temario temario) {
        return temarioRepository.save(temario);
    }

    @Override
    public Set<Temario> obtenerTemarios() {
        return new LinkedHashSet<>(temarioRepository.findAll());
    }

    @Override
    public Temario obtenerTemario(Integer idTemario) {
        return temarioRepository.findById(idTemario).get();
    }

    @Override
    public void eliminarTemario(Integer idTemario) {
        Temario temario = new Temario();
        temario.setIdTemario(idTemario);
        temarioRepository.delete(temario);
    }

    @Override
    public Set<Temario> obtenerTemarioDelCurso(Curso curso) {
        return temarioRepository.findByCurso(curso);
    }


}
