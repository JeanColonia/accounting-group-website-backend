package com.grupocontable.website.service;
import com.grupocontable.website.model.Curso;
import java.util.Set;

public interface CursoService {
Curso agregarCurso(Curso curso);
Curso actualizarCurso(Curso curso);
Set<Curso> obtenerCursos();
Curso obtenerCurso(Integer cursoId);
void eliminarCurso(Integer cursoId);

}
