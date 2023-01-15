package com.grupocontable.website.controllers;

import com.grupocontable.website.model.Curso;
import com.grupocontable.website.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso/api")
@CrossOrigin("*")
public class CursoController {

    private final CursoService cursoService;
    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @PostMapping("/")
    public ResponseEntity<Curso> agregarCurso(@RequestBody Curso curso){
        Curso cursoSaved = cursoService.agregarCurso(curso);
        return ResponseEntity.ok(cursoSaved);
    }

    @PutMapping("/")
    public Curso actualizarCurso(@RequestBody Curso curso){
        return cursoService.actualizarCurso(curso);
    }

    @GetMapping("/")
    public ResponseEntity<?> obtenerCursos(){
        return ResponseEntity.ok(cursoService.obtenerCursos());
    }

    @GetMapping("/{idCurso}")
    public Curso obtenerCurso(@PathVariable("idCurso") Integer idCurso){
        return cursoService.obtenerCurso(idCurso);
    }

    @DeleteMapping("/{idCurso}")
    public void eliminarCurso(@PathVariable("idCurso") Integer idCurso){
        cursoService.eliminarCurso(idCurso);
    }


}
