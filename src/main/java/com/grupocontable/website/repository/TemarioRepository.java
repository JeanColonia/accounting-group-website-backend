package com.grupocontable.website.repository;

import com.grupocontable.website.model.Curso;
import com.grupocontable.website.model.Temario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface TemarioRepository extends JpaRepository<Temario, Integer> {
    Set<Temario> findByCurso(Curso curso);
}
