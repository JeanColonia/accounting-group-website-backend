package com.grupocontable.website.service.Impl;


import com.grupocontable.website.model.Pagina;
import com.grupocontable.website.repository.PaginaRepository;
import com.grupocontable.website.service.PaginaService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class PaginaServiceImp implements PaginaService {
    private final PaginaRepository paginaRepository;

    public PaginaServiceImp(PaginaRepository paginaRepository){
        this.paginaRepository = paginaRepository;
    }

    @Override
    public Pagina crearPagina(Pagina pagina) {
    return paginaRepository.save(pagina);
    }

    @Override
    public Pagina actualizarPagina(Pagina pagina) {
        return paginaRepository.save(pagina);
    }

    @Override
    public Set<Pagina> listarPaginas() {
        return new LinkedHashSet<>(paginaRepository.findAll());
    }

    @Override
    public Pagina obtenerPagina(Integer idPagina) {
        return paginaRepository.findById(idPagina).get();
    }

    @Override
    public void eliminarPagina(Integer idPagina) {
    Pagina pagina = new Pagina();
    pagina.setIdPagina(idPagina);

    paginaRepository.delete(pagina);
    }
}
