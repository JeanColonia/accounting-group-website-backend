package com.grupocontable.website.repository;


import com.grupocontable.website.model.Pagina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginaRepository extends JpaRepository<Pagina,Integer> {
}
