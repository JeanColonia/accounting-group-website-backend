package com.grupocontable.website.controllers;

import com.grupocontable.website.model.Temario;
import com.grupocontable.website.service.TemarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("temario/api")
public class TemarioController {
    private final TemarioService temarioService;

    public TemarioController(TemarioService temarioService) {
        this.temarioService = temarioService;
    }

    @GetMapping("/listar")
    public List<Temario> listar(){
        return temarioService.listar();
    }

    @GetMapping("/obtenerTemario/{id}")
    public ResponseEntity<Temario> obtenerTemario(@PathVariable Integer id){
        try{
            Temario temario=temarioService.obtenerTemario(id);
            return new ResponseEntity<Temario>(temario, HttpStatus.OK);
        }catch(Exception e){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/agregarTemario")
    public void agregarTemario(@RequestBody Temario temario){
        temarioService.agregarTemario(temario);
    }

    @PutMapping("/actualizarTemario/{id}")
    public ResponseEntity<?> actualizarTemario(@RequestBody Temario temario, @PathVariable Integer id){
        try {
            Temario getTemario=temarioService.obtenerTemario(id);
            getTemario.setTitulo(temario.getTitulo());
            getTemario.setDescripcion(temario.getDescripcion());

            temarioService.agregarTemario(getTemario);

            return new ResponseEntity<Temario>(getTemario,HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<Temario>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/eliminarTemario/{id}")
    public void eliminarTemario(@PathVariable Integer  id){
        temarioService.eliminarTemario(id);
    }


}
