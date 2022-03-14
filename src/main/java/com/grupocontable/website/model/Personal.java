package com.grupocontable.website.model;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Personal  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personal", nullable = false)
    private Integer id;

    String nombres;
    String apellidos;
    String descripcion;
    String cargo_profesion;
    String fotografia;
    String pais;
    String rol_personal;

}

