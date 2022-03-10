package com.grupocontable.website.controllers;


import com.grupocontable.website.model.Personal;
import com.grupocontable.website.service.PersonalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personal/api")
public class PersonalController {

    private final PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping("/listar")
    public List<Personal> listarPersonal(){
        return personalService.listarPersonal();
    }

    @GetMapping("/obtenerPersonal/{id}")
    public ResponseEntity<Personal> obtenerPersonal(@PathVariable Integer id){
        try {
             Personal personal = personalService.obtenerPersonal(id);
             return new ResponseEntity<Personal>(personal, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Personal>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/agregarPersonal")
    public void agregarPersonal (@RequestBody Personal personal){
        personalService.guardarPersonal(personal);
    }

    @PutMapping("/actualizarPersonal/{id}")
    public ResponseEntity<?> actualizarPersonal(@RequestBody Personal personal, @PathVariable Integer id){
       try{
           Personal obtenerPersonal=personalService.obtenerPersonal(id);
           obtenerPersonal.setNombres(personal.getNombres());
           obtenerPersonal.setApellidos(personal.getApellidos());
           obtenerPersonal.setDescripcion(personal.getDescripcion());
           obtenerPersonal.setCargo_profesion(personal.getCargo_profesion());
           obtenerPersonal.setFotografia(personal.getFotografia());
           obtenerPersonal.setPais(personal.getPais());
           obtenerPersonal.setRol_personal(personal.getRol_personal());

           personalService.guardarPersonal(obtenerPersonal);
           return new ResponseEntity<Personal>( obtenerPersonal,HttpStatus.OK);

       }catch(Exception e){
        return new ResponseEntity<Personal>(HttpStatus.NOT_FOUND);
       }

    }


    @DeleteMapping("/eliminarPersonal/{id}")
    public void eliminarPersonal(@PathVariable Integer id){
        personalService.eliminarPersonal(id);
    }
}
