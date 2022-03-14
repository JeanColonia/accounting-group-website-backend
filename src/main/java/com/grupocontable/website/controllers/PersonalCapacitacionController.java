package com.grupocontable.website.controllers;

import com.grupocontable.website.model.PersonalCapacitacion;
import com.grupocontable.website.service.PersonalCapacitacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personalCapacitacion/api")
public class PersonalCapacitacionController {

    private final PersonalCapacitacionService personalCapacitacionService;

    public PersonalCapacitacionController(PersonalCapacitacionService personalCapacitacionService) {
        this.personalCapacitacionService = personalCapacitacionService;
    }

    @GetMapping("/listar")
    public List<PersonalCapacitacion> listar(){
        return personalCapacitacionService.listar();
    }

    @GetMapping("/obtenerPersonalCapacitacion/{id}")
    public PersonalCapacitacion obtenerPersonalCapacitacion(@PathVariable Integer id){
       return personalCapacitacionService.obtenerPersonalCapacitacion(id);
    }

    @PostMapping("/agregarPersonalCapacitacion")
    public void agregarPersonalCapacitacion(PersonalCapacitacion personalCapacitacion){
        personalCapacitacionService.agregarPersonalCapacitacion(personalCapacitacion);
    }

    @PutMapping("/actualizarPersonalCapacitacion/{id}")
    public ResponseEntity<?> actualizarPersonalCapacitacion(@RequestBody PersonalCapacitacion personalCapacitacion, @PathVariable Integer id){
        try{
            PersonalCapacitacion obtenerPersonalCapacitacion=personalCapacitacionService.obtenerPersonalCapacitacion(id);
            obtenerPersonalCapacitacion.setPersonal(personalCapacitacion.getPersonal());
            obtenerPersonalCapacitacion.setCapacitacion(personalCapacitacion.getCapacitacion());

            personalCapacitacionService.agregarPersonalCapacitacion(obtenerPersonalCapacitacion);

            return new ResponseEntity<PersonalCapacitacion>(obtenerPersonalCapacitacion,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<PersonalCapacitacion>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/eliminarPersonalCapacitacion/{id}")
    public void eliminarPersonalCapacitacion(@PathVariable Integer id){

        personalCapacitacionService.eliminarPersonalCapacitacion(id);
    }

}

