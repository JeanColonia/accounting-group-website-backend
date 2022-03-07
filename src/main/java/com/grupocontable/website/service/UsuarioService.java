package com.grupocontable.website.service;

import com.grupocontable.website.model.Usuario;
import com.grupocontable.website.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario obtenerUsuario(Integer id){
        return usuarioRepository.findById(id).get();
    }

    public void agregarUsuario(Usuario usuario){
         usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Integer id){
        usuarioRepository.deleteById(id);
    }
}
