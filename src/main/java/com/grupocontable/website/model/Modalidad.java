package com.grupocontable.website.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "modalidad")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Modalidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idModalidad;
    String nombre;
    String descripcion;

    @OneToMany(mappedBy = "modalidad", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Curso> cursos = new LinkedHashSet<>();


    @OneToMany(mappedBy = "modalidad_evento" , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Evento> evento = new LinkedHashSet<>();
}
