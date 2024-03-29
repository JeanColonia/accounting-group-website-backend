package com.grupocontable.website.repository;

import com.grupocontable.website.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
Usuario findByNombreUsuario(String nombreUsuario);
}
