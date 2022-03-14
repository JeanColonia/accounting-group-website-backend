package com.grupocontable.website.controllers;

import com.grupocontable.website.model.PersonalCapacitacion;
import com.grupocontable.website.model.PersonalServicio;
import com.grupocontable.website.service.PersonalCapacitacionService;
import com.grupocontable.website.service.PersonalServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personalServicio/api")
public class PersonalServicioController {

    private final PersonalServicioService personalServicioService;

    public PersonalServicioController(PersonalServicioService personalServicioService) {
        this.personalServicioService = personalServicioService;
    }

    @GetMapping("/listar")
    public List<PersonalServicio> listar(){
        return personalServicioService.listar();
    }

    @GetMapping("/obtenerPersonalCapacitacion/{id}")
    public PersonalServicio obtenerPersonalCapacitacion(@PathVariable Integer id){
       return personalServicioService.obtenerPersonalServicio(id);
    }

    @PostMapping("/agregarPersonalCapacitacion")
    public void agregarPersonalCapacitacion(PersonalServicio personalServicio){
        personalServicioService.agregarPersonalServicio(personalServicio);
    }

    @PutMapping("/actualizarPersonalCapacitacion/{id}")
    public ResponseEntity<?> actualizarPersonalServicio(@RequestBody PersonalServicio personalServicio, @PathVariable Integer id){
        try{
            PersonalServicio obtenerPersonalServicio=personalServicioService.obtenerPersonalServicio(id);
            obtenerPersonalServicio.setPersonal(personalServicio.getPersonal());
            obtenerPersonalServicio.setServicio(personalServicio.getServicio());

            personalServicioService.agregarPersonalServicio(obtenerPersonalServicio);

            return new ResponseEntity<PersonalServicio>(obtenerPersonalServicio,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<PersonalCapacitacion>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/eliminarPersonalCapacitacion/{id}")
    public void eliminarPersonalCapacitacion(@PathVariable Integer id){

        personalServicioService.eliminarPersonalServicio(id);
    }

}

