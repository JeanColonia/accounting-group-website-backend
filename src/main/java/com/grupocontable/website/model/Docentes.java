package com.grupocontable.website.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Docentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personal", nullable = false)
    private Integer id;

    String nombres;
    String apellidos;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String descripcion;
    String fotografia;
    String pais;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Curso> cursos = new LinkedHashSet<>();

}

