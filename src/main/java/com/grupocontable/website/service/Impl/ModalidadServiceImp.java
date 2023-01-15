package com.grupocontable.website.service.Impl;

import com.grupocontable.website.model.Modalidad;
import com.grupocontable.website.repository.ModalidadRepository;
import com.grupocontable.website.service.ModalidadService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class ModalidadServiceImp implements ModalidadService {

    private final ModalidadRepository modalidadRepository;

    public ModalidadServiceImp(ModalidadRepository modalidadRepository){
        this.modalidadRepository = modalidadRepository;
    }

    @Override
    public Modalidad crearModalidad(Modalidad modalidad) {
        return modalidadRepository.save(modalidad);
    }

    @Override
    public Modalidad actualizarModalidad(Modalidad modalidad) {
        return modalidadRepository.save(modalidad);
    }

    @Override
    public Set<Modalidad> obtenerModalidades() {
        return new LinkedHashSet<>(modalidadRepository.findAll());
    }

    @Override
    public Modalidad obtenerModalidad(Integer idModalidad) {
        return modalidadRepository.findById(idModalidad).get();
    }

    @Override
    public void eliminarModalidad(Integer idModalidad) {
    Modalidad modalidad = new Modalidad();
    modalidad.setIdModalidad(idModalidad);
    modalidadRepository.delete(modalidad);

    }
}
