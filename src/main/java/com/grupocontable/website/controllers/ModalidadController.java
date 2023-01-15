package com.grupocontable.website.controllers;


import com.grupocontable.website.model.Modalidad;
import com.grupocontable.website.service.ModalidadService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("modalidad/api")
@CrossOrigin("*")
public class ModalidadController {

    private final ModalidadService modalidadService;
    public ModalidadController(ModalidadService modalidadService){
        this.modalidadService = modalidadService;
    }

    @PostMapping("/")
    public ResponseEntity<Modalidad> crearModalidad(@RequestBody Modalidad modalidad){
        Modalidad modalidadSaved = modalidadService.crearModalidad(modalidad);
        return ResponseEntity.ok(modalidadSaved);
    }

    @PutMapping("/")
    public Modalidad actualizarModalidad(@RequestBody Modalidad modalidad){
        return modalidadService.actualizarModalidad(modalidad);
    }

    @GetMapping("/")
    public ResponseEntity<?> obtenerModalidades(){
        return ResponseEntity.ok(modalidadService.obtenerModalidades());
    }

    @GetMapping("/{idModalidad}")
    public Modalidad obtenerModalidad(@PathVariable("idModalidad") Integer idModalidad){
        return modalidadService.obtenerModalidad(idModalidad);
    }

    @DeleteMapping("/{idModalidad}")
    public void eliminarModalidad(@PathVariable("idModalidad") Integer idModalidad){
        modalidadService.eliminarModalidad(idModalidad);
    }

}
