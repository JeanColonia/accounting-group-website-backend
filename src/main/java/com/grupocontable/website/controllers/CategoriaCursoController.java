package com.grupocontable.website.controllers;

import com.grupocontable.website.model.CategoriaCurso;
import com.grupocontable.website.service.CategoriaCursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categoria-curso/api")
@CrossOrigin("*")
public class CategoriaCursoController {
    private final CategoriaCursoService categoriaCursoService;
    public CategoriaCursoController(CategoriaCursoService categoriaCursoService){
        this.categoriaCursoService = categoriaCursoService;
    }


    @PostMapping("/")
    public ResponseEntity<CategoriaCurso> agregarCategoriaCurso(@RequestBody CategoriaCurso categoriaCurso){
        CategoriaCurso categoriaSaved = categoriaCursoService.crearCategoriaCurso(categoriaCurso);
        return ResponseEntity.ok(categoriaSaved);
    }

    @PutMapping("/")
    public CategoriaCurso actualizarCategoriaCruso(@RequestBody CategoriaCurso categoriaCurso){
        return categoriaCursoService.actualizarCategoriaCurso(categoriaCurso);
    }

    @GetMapping("/")
    public ResponseEntity<?> obtenerCategoriasCursos(){
        return ResponseEntity.ok(categoriaCursoService.obtenerCategoriasCursos());
    }

    @GetMapping("/{idCategoriaCurso}")
    public CategoriaCurso obtenerCategoriaCurso(@PathVariable("idCategoriaCurso") Integer idCategoriaCurso){
        return categoriaCursoService.obtenerCategoriaCurso(idCategoriaCurso);
    }

    @DeleteMapping("/{idCategoriaCurso}")
    public void eliminarCategoriaCurso(@PathVariable("idCategoriaCurso") Integer idCategoriaCurso){
        categoriaCursoService.eliminarCategoriaCurso(idCategoriaCurso);
    }
}
