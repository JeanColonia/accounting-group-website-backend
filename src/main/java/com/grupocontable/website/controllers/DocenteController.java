package com.grupocontable.website.controllers;

import com.grupocontable.website.model.Docentes;
import com.grupocontable.website.service.DocenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docente/api")
@CrossOrigin("*")
public class DocenteController {
private final DocenteService docentesService;
    public DocenteController(DocenteService docenteService){
        this.docentesService = docenteService;
    }

@PostMapping("/")
    public ResponseEntity<Docentes> agregarDocente(@RequestBody Docentes docente){
    Docentes docenteSaved = docentesService.crearDocente(docente);
    return ResponseEntity.ok(docenteSaved);
}

@PutMapping("/")
    public Docentes actualizarDocente(@RequestBody Docentes docente){
    return docentesService.actualizarDocente(docente);
}

@GetMapping("/")
    public ResponseEntity<?> obtenerDocentes(){
        return ResponseEntity.ok(docentesService.obtenerDocentes());
}

@GetMapping("/{idDocente}")
    public Docentes obtenerDocente(@PathVariable("idDocente") Integer idDocente){
        return docentesService.obtenerDocente(idDocente);
}

@DeleteMapping("/{idDocente}")
    public void eliminarDocente(@PathVariable("idDocente") Integer idDocente){
        docentesService.eliminarDocente(idDocente);
}

}
