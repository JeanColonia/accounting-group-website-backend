package com.grupocontable.website.repository;

import com.grupocontable.website.model.Curso;
import com.grupocontable.website.model.ImagenCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface ImagenRepository  extends JpaRepository<ImagenCurso, Integer> {
List<ImagenCurso> findByOrderById();

}
