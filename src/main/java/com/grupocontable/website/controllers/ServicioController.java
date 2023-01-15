package com.grupocontable.website.controllers;

import com.grupocontable.website.model.Servicio;
import com.grupocontable.website.service.ServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio/api")
@CrossOrigin("*")
public class ServicioController {

        private final ServicioService servicioService;
        public ServicioController(ServicioService servicioService){
            this.servicioService = servicioService;
        }

     @PostMapping()
     public ResponseEntity<Servicio> agregarServicio(@RequestBody Servicio servicio){
            Servicio servicioSaved = servicioService.crearServicio(servicio);
            return ResponseEntity.ok(servicioSaved);
     }

     @PutMapping("/")
     public Servicio actualizarServicio(@RequestBody Servicio servicio){
            return servicioService.actualizarServicio(servicio);
     }

     @GetMapping("/")
    public ResponseEntity<?> obtenerServicios(){
            return ResponseEntity.ok(servicioService.obtenerServicios());
     }


     @GetMapping("/{idServicio}")
    public Servicio obtenerServicio(@PathVariable("idServicio") Integer idServicio){
            return servicioService.obtenerServicio(idServicio);
     }


     @DeleteMapping("/{idServicio}")
    public void eliminarServicio(@PathVariable("idServicio") Integer idServicio){
            servicioService.eliminarServicio(idServicio);
     }

}
