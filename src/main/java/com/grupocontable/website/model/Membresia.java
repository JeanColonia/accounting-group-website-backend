package com.grupocontable.website.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Membresia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idMembresia;

    String precio;
    String tipoMembresia;
    String descripcion1;
    String descripcion2;
    String descripcion3;
    String descripcion4;
    String descripcion5;
    String descripcion6;
    String descripcion7;
    String descripcion8;
    String descripcion9;
    String descripcion10;
    String descripcion11;
    boolean mostrar=false;


}
