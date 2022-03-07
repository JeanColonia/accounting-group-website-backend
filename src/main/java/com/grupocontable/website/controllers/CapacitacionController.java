package com.grupocontable.website.controllers;

import com.grupocontable.website.model.Capacitacion;
import com.grupocontable.website.service.CapacitacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capacitacion/api")
public class CapacitacionController {
    private final CapacitacionService capacitacionService;

    public CapacitacionController(CapacitacionService capacitacionService) {
        this.capacitacionService = capacitacionService;
    }

    @GetMapping("/listar")
    public List<Capacitacion> listar(){
        return capacitacionService.listar();
    }

    @GetMapping("/obtenerCapacitacion/{id}")
    public ResponseEntity<Capacitacion> obtenerCapacitacion(@PathVariable Integer id){
        try{
            Capacitacion obtenercapacitacion=capacitacionService.obtenerCapacitacion(id);
            return new ResponseEntity<Capacitacion>(obtenercapacitacion, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Capacitacion>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/agregarCapacitacion")
    public void agregarCapacitacion(@RequestBody Capacitacion capacitacion){
        capacitacionService.agregarCapacitacion(capacitacion);
    }

    @PutMapping("/actualizarCapacitacion/{id}")
    public ResponseEntity<?> actualizarCapacitacion(@RequestBody Capacitacion capacitacion, @PathVariable Integer id){
        try{
            Capacitacion obtenercapacitacion=capacitacionService.obtenerCapacitacion(id);
            obtenercapacitacion.setTitulo(capacitacion.getTitulo());
            obtenercapacitacion.setTipoCapacitacion(capacitacion.getTipoCapacitacion());
            obtenercapacitacion.setFecha(capacitacion.getFecha());
            obtenercapacitacion.setDescripcion(capacitacion.getDescripcion());
            obtenercapacitacion.setFgVirtual(capacitacion.getFgVirtual());
            obtenercapacitacion.setServicio(capacitacion.getServicio());

            capacitacionService.agregarCapacitacion(obtenercapacitacion);
            return new ResponseEntity<Capacitacion>(obtenercapacitacion, HttpStatus.OK);
        }catch(Exception e){

            return new ResponseEntity<Capacitacion>(HttpStatus.NOT_MODIFIED);
        }
    }


    @DeleteMapping("/eliminarCapacitacion/{id}")
    public void eliminarCapacitacion(Integer id){
        capacitacionService.eliminarCapacitacion(id);
    }


}
