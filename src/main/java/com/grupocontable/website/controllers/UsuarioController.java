package com.grupocontable.website.controllers;
import com.grupocontable.website.model.Usuario;
import com.grupocontable.website.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario/api")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("/listar")
    public List<Usuario> listarUsuarios(){
    return usuarioService.listarUsuarios();
    }

    @GetMapping("/obtenerUsuario/{id}")
    public ResponseEntity<Usuario> obtenerUsuario (@PathVariable Integer id){
       try{
           Usuario usuario= usuarioService.obtenerUsuario(id);
           return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
       }catch(Exception e){
           return new ResponseEntity<Usuario>( HttpStatus.NOT_FOUND);
       }
    }

    @PostMapping("/agregarUsuario")
    public void agregarUsuario(@RequestBody Usuario usuario){
        usuarioService.agregarUsuario(usuario);
    }

    @PutMapping("/actualizarUsuario/{id}")
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id){
            try{
                Usuario obtenerUsuario=usuarioService.obtenerUsuario(id);
                obtenerUsuario.setNombreUsuario(usuario.getNombreUsuario());
                obtenerUsuario.setTipoUsuario(usuario.getTipoUsuario());
                obtenerUsuario.setPass(usuario.getPass());

                usuarioService.agregarUsuario(obtenerUsuario);
                return new ResponseEntity<Usuario>(obtenerUsuario,HttpStatus.OK);

            }catch(Exception e) {
                return new ResponseEntity<Usuario>(HttpStatus.NOT_MODIFIED);
            }
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        usuarioService.eliminarUsuario(id);
    }


}

