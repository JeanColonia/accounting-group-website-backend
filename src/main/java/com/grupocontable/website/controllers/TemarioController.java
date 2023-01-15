package com.grupocontable.website.controllers;

import com.grupocontable.website.model.Curso;
import com.grupocontable.website.model.Temario;
import com.grupocontable.website.service.CursoService;
import com.grupocontable.website.service.TemarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("temario/api")
@CrossOrigin("*")
public class TemarioController {
private final TemarioService temarioService;
private final CursoService cursoService;
public TemarioController(TemarioService temarioService, CursoService cursoService){
    this.temarioService = temarioService;
    this.cursoService = cursoService;
}

@PostMapping("/")
    public ResponseEntity<Temario> crearTemario(@RequestBody Temario temario){
    Temario temarioSaved = temarioService.crearTemario(temario);
    return ResponseEntity.ok(temarioSaved);
}

@PutMapping("/")
    public Temario actualizarTemario(@RequestBody Temario temario){
    return temarioService.actualizarTemario(temario);
}


@GetMapping("/")
    public ResponseEntity<?> obtenerTemarios(){
    return ResponseEntity.ok(temarioService.obtenerTemarios());
}


@GetMapping("/{idTemario}")
    public Temario obtenerTemario(@PathVariable("idTemario") Integer idTemario){
    return temarioService.obtenerTemario(idTemario);
}

@DeleteMapping("/{idTemario}")
    public void eliminarTemario(@PathVariable("idTemario") Integer idTemario){
    temarioService.eliminarTemario(idTemario);
}

@GetMapping("/curso/{idCurso}")
    public ResponseEntity<?> obtenerTemarioPorExamen(@PathVariable("idCurso") Integer idCurso){
    Curso curso = cursoService.obtenerCurso(idCurso);
    Set<Temario> temarioDelCurso = curso.getTemario();

    return ResponseEntity.ok(temarioDelCurso);
}

}
