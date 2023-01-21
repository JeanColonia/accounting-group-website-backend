package com.grupocontable.website.service;

import com.grupocontable.website.model.Pagina;

import java.util.Set;

public interface PaginaService {

    Pagina crearPagina(Pagina pagina);
    Pagina actualizarPagina(Pagina pagina);
    Set<Pagina> listarPaginas();
    Pagina obtenerPagina(Integer idPagina);
    void eliminarPagina(Integer idPagina);


}
