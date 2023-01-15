package com.grupocontable.website.repository;

import com.grupocontable.website.model.CategoriaCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaCursoRepository extends JpaRepository<CategoriaCurso, Integer> {

}
