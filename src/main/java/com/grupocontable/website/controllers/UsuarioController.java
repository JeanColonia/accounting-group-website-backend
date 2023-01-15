package com.grupocontable.website.controllers;
import com.grupocontable.website.model.Usuario;
import com.grupocontable.website.service.UsuarioService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("usuario/api")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
    Set<Usuario> lista = this.usuarioService.obtenerUsuarios();
    Usuario usuarioSaved = usuarioService.agregarUsuario(usuario);
    return ResponseEntity.ok(usuarioSaved);
    }


    @PutMapping("/")
    public Usuario actualizarUsuario(@RequestBody Usuario usuario){
        return usuarioService.actualizarUsuario(usuario);
    }

    @GetMapping("/")
    public ResponseEntity<?> obtenerUsuarios(){
        return ResponseEntity.ok(usuarioService.obtenerUsuarios());
    }

    @GetMapping("/{idUsuario}")
    public Usuario obtenerUsuario(@PathVariable("idUsuario") Integer idUsuario){
        return usuarioService.obtenerUsuario(idUsuario);
    }

    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuario(@PathVariable("idUsuario") Integer idUsuario){
        usuarioService.eliminarUsuario(idUsuario);
    }


}

