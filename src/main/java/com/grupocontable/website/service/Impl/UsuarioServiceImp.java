package com.grupocontable.website.service.Impl;

import com.grupocontable.website.model.Usuario;
import com.grupocontable.website.repository.UsuarioRepository;
import com.grupocontable.website.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario agregarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Set<Usuario> obtenerUsuarios() {
        return new LinkedHashSet<>(usuarioRepository.findAll());
    }

    @Override
    public Usuario obtenerUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).get();
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
    Usuario usuario = new Usuario();
    usuario.setIdUsuario(idUsuario);
    usuarioRepository.delete(usuario);
    }



}
