package com.grupocontable.website.service;

import com.grupocontable.website.model.Usuario;
import com.grupocontable.website.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface UsuarioService {

    Usuario agregarUsuario(Usuario usuario);
    Usuario actualizarUsuario(Usuario usuario);
    Set<Usuario> obtenerUsuarios();
    Usuario obtenerUsuario(Integer idUsuario);
    void eliminarUsuario(Integer idUsuario);

}
