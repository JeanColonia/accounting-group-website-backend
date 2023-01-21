package com.grupocontable.website.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pagina {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Integer idPagina;

    String ruta;

    String titulo;

    String Miniatura;

    String imagenPagina;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String descripcionUno;

    String imagenDescripcionUno;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String descripcionDos;


    String imagenDescripcionDos;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String descripcionTres;


    String imagenDescripcionTres;
}
