package com.grupocontable.website.repository;

import com.grupocontable.website.model.Curso;
import com.grupocontable.website.model.Modalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    Set<Curso>  findByModalidad(Modalidad modalidad);
}
