package com.grupocontable.website.service.Impl;

import com.grupocontable.website.model.Membresia;
import com.grupocontable.website.repository.MembresiaRepository;
import com.grupocontable.website.service.MembresiaService;

import java.util.LinkedHashSet;
import java.util.Set;

public class MembresiaServiceImp implements MembresiaService {

    private final MembresiaRepository membresiaRepository;
    public MembresiaServiceImp(MembresiaRepository membresiaRepository){
        this.membresiaRepository = membresiaRepository;
    }
    @Override
    public Membresia crearMembresia(Membresia membresia) {
        return membresiaRepository.save(membresia);
    }

    @Override
    public Membresia actualizarMembresia(Membresia membresia) {
        return membresiaRepository.save(membresia);
    }

    @Override
    public Set<Membresia> listarMembresias() {
        return new LinkedHashSet<>(membresiaRepository.findAll());
    }

    @Override
    public Membresia obtenerMembresia(Integer idMembresia) {
        return membresiaRepository.findById(idMembresia).get();
    }

    @Override
    public void eliminarMembresia(Integer idMembresia) {
        Membresia membresia = new Membresia();
        membresia.setIdMembresia(idMembresia);
        membresiaRepository.delete(membresia);
    }
}
