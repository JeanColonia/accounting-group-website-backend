package com.grupocontable.website.service.Impl;

import com.grupocontable.website.model.Docentes;
import com.grupocontable.website.repository.DocenteRepository;
import com.grupocontable.website.service.DocenteService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class DocenteServiceImp implements DocenteService {

    private final DocenteRepository docenteRepository;
    public DocenteServiceImp(DocenteRepository docenteRepository){
        this.docenteRepository = docenteRepository;
    }
    @Override
    public Docentes crearDocente(Docentes docente) {
        return docenteRepository.save(docente);
    }

    @Override
    public Docentes actualizarDocente(Docentes docente) {
        return docenteRepository.save(docente);
    }

    @Override
    public Set<Docentes> obtenerDocentes() {
        return new LinkedHashSet<>(docenteRepository.findAll());
    }

    @Override
    public Docentes obtenerDocente(Integer idDocente) {
        return docenteRepository.findById(idDocente).get();
    }

    @Override
    public void eliminarDocente(Integer idDocente) {
        Docentes docente = new Docentes();
        docente.setId(idDocente);
        docenteRepository.delete(docente);
    }
}
