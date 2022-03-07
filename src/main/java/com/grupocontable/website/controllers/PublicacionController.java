package com.grupocontable.website.controllers;

import com.grupocontable.website.model.Publicacion;
import com.grupocontable.website.service.PublicacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("publicacion/api")
public class PublicacionController {
    private final PublicacionService publicacionService;

    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @GetMapping("/listar")
    public List<Publicacion> listar(){
        return publicacionService.listar();
    }
    @GetMapping("/obtenerPublicacion/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacion(@PathVariable Integer id){
        try{
            Publicacion publicacion=publicacionService.obtenerPublicacion(id);
            return new ResponseEntity<Publicacion>(publicacion, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Publicacion>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/agregarPublicacion")
    public void agregarPublicacion(@RequestBody Publicacion publicacion){
        publicacionService.agregarPublicacion(publicacion);
    }


    @PutMapping("/actualizarPublicacion/{id}")
    public ResponseEntity<?> actualizarPublicacion(@RequestBody Publicacion publicacion, @PathVariable Integer id){
        try{
            Publicacion obtenerpublicacion=publicacionService.obtenerPublicacion(id);

            obtenerpublicacion.setNombre(publicacion.getNombre());
            obtenerpublicacion.setFecha(publicacion.getFecha());
            obtenerpublicacion.setTipoPublicacion(publicacion.getTipoPublicacion());
            obtenerpublicacion.setImagen(publicacion.getImagen());
            obtenerpublicacion.setAutor(publicacion.getAutor());
            obtenerpublicacion.setCargoAutor(publicacion.getCargoAutor());
            obtenerpublicacion.setDescripcion(publicacion.getDescripcion());
            obtenerpublicacion.setUsuario(publicacion.getUsuario());

            publicacionService.agregarPublicacion(obtenerpublicacion);
            return  new ResponseEntity<Publicacion>(obtenerpublicacion,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/eliminarPublicacion/{id}")
    public void eliminarPublicacion(@PathVariable Integer id){
        publicacionService.eliminarPublicacion(id);
    }

}
