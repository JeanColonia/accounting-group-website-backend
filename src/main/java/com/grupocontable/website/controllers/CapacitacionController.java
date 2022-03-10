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
            obtenercapacitacion.setImagen(capacitacion.getImagen());
            obtenercapacitacion.setFgVirtual(capacitacion.getFgVirtual());
            obtenercapacitacion.setHoraInicio(capacitacion.getHoraInicio());
            obtenercapacitacion.setHoraFin(capacitacion.getHoraFin());
            obtenercapacitacion.setModalidad(capacitacion.getTipoCapacitacion());
            obtenercapacitacion.setIntroduccion(capacitacion.getIntroduccion());
            obtenercapacitacion.setObjetivo(capacitacion.getObjetivo());
            obtenercapacitacion.setMetodologia(capacitacion.getMetodologia());
            obtenercapacitacion.setBeneficios(capacitacion.getBeneficios());
            obtenercapacitacion.setInversionPresencial(capacitacion.getInversionPresencial());
            obtenercapacitacion.setInversionVirtual(capacitacion.getInversionVirtual());
            obtenercapacitacion.setDescuentos(capacitacion.getDescuentos());
            obtenercapacitacion.setUsuario(capacitacion.getUsuario());
            obtenercapacitacion.setDirigidoTipoProfesionales(capacitacion.getDirigidoTipoProfesionales());


            capacitacionService.agregarCapacitacion(obtenercapacitacion);
            return new ResponseEntity<Capacitacion>(obtenercapacitacion, HttpStatus.OK);
        }catch(Exception e){

            return new ResponseEntity<Capacitacion>(HttpStatus.NOT_MODIFIED);
        }
    }


    @DeleteMapping("/eliminarCapacitacion/{id}")
    public void eliminarCapacitacion(@PathVariable Integer id){

        capacitacionService.eliminarCapacitacion(id);
    }


}
