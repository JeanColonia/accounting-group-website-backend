package com.grupocontable.website.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "categoria_curso")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCategoriaCurso;
    String tituloCategoriaCurso;
    String descripcion;

    /******* OBTENEMOS UN LISTADO DE CURSOS DEL TIPO CURSO CORRESPONDIENTE **************/
    @OneToMany(mappedBy = "categoriacurso", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Curso> cursos = new LinkedHashSet<>();
}
