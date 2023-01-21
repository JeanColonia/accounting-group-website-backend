package com.grupocontable.website.controllers;


import com.grupocontable.website.model.Pagina;
import com.grupocontable.website.service.PaginaService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("pagina/api")
public class PaginaController {
    private final PaginaService paginaService;

    public PaginaController(PaginaService paginaService){
        this.paginaService = paginaService;
    }

    @PostMapping("/")
    public ResponseEntity<Pagina> crearPagina(@RequestBody Pagina pagina){
        Pagina paginaSaved = paginaService.crearPagina(pagina);
        return ResponseEntity.ok(paginaSaved);
    }


    @PutMapping("/")
    public Pagina actualizarPagina(@RequestBody Pagina pagina){
        return paginaService.actualizarPagina(pagina);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarPaginas(){
        return ResponseEntity.ok(paginaService.listarPaginas());
    }

    @GetMapping("/{idPagina}")
    public Pagina obtenerPagina(@PathVariable("idPagina") Integer idPagina){
        return paginaService.obtenerPagina(idPagina);
    }


    @DeleteMapping("/{idPagina}")
    public void eliminarPagina(@PathVariable("idPagina") Integer idPagina){
         paginaService.eliminarPagina(idPagina);
    }
}
