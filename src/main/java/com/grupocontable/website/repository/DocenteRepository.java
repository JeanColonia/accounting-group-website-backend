package com.grupocontable.website.repository;

import com.grupocontable.website.model.Docentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docentes, Integer> {

}
