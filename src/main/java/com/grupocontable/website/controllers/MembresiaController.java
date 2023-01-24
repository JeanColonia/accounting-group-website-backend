package com.grupocontable.website.controllers;


import com.grupocontable.website.model.Membresia;
import com.grupocontable.website.model.Modalidad;
import com.grupocontable.website.service.MembresiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("membresia/api")
public class MembresiaController {
    private final MembresiaService membresiaService;
    public MembresiaController(MembresiaService membresiaService){
        this.membresiaService = membresiaService;
    }



    @GetMapping("/")
    public ResponseEntity<?> listarMembresias(){
        return ResponseEntity.ok(membresiaService.listarMembresias());
    }

    @GetMapping("/{idMembresia}")
    public Membresia listarMembresias(@PathVariable("idMembresia") Integer idMembresia){
        return membresiaService.obtenerMembresia(idMembresia);
    }



    @PostMapping("/")
    public ResponseEntity<Membresia> listarMembresias(Membresia membresia){
        Membresia membresiaSaved = membresiaService.crearMembresia(membresia);

        return ResponseEntity.ok(membresiaSaved);
    }


    @PutMapping("/")
    public Membresia actualizarMembresia(Membresia membresia){
        return membresiaService.actualizarMembresia(membresia);
    }

    @DeleteMapping("/{idMembresia}")
    public void eliminarMembresia(@PathVariable("idMembresia") Integer idMembresia){
         membresiaService.eliminarMembresia(idMembresia);
    }






}
