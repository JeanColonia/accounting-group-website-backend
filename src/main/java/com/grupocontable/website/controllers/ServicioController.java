package com.grupocontable.website.controllers;

import com.grupocontable.website.model.Servicio;
import com.grupocontable.website.service.ServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio/api")
public class ServicioController {
    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping("/listar")
    public List<Servicio> listar(){
        return servicioService.listar();
    }

    @GetMapping("/obtenerServicio/{id}")
    public ResponseEntity<Servicio> obtenerServicio(@PathVariable Integer id){
        try{
            Servicio obtenerservicio=servicioService.obtenerServicio(id);

            return new ResponseEntity<Servicio>(obtenerservicio, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Servicio>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/agregarServicio")
    public void agregarServicio(@RequestBody Servicio servicio){
         servicioService.agregarServicio(servicio);
    }

    @PutMapping("/actualizarServicio/{id}")
    public ResponseEntity<?> actualizarServicio(@RequestBody Servicio servicio, @PathVariable Integer id){
        try{
            Servicio obtenerservicio=servicioService.obtenerServicio(id);
            obtenerservicio.setFotografia(servicio.getFotografia());
            obtenerservicio.setTitulo(servicio.getTitulo());
            obtenerservicio.setTipo(servicio.getTitulo());
            obtenerservicio.setFecha(servicio.getFecha());
            obtenerservicio.setDescripcion(servicio.getDescripcion());
            obtenerservicio.setFgVirtual(servicio.getFgVirtual());

            servicioService.agregarServicio(obtenerservicio);
            return new ResponseEntity<Servicio>(obtenerservicio, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Servicio>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/eliminarServicio/{id}")
    public void eliminarServicio(@PathVariable Integer id){
        servicioService.eliminarServicio(id);
    }
}
