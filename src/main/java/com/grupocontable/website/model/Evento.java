package com.grupocontable.website.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id_evento")
    Integer idEvento;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String titulo;
    @Column(name="fecha")
    String fecha;


    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String descripcion;

    @Column(name="imagen")
    String fotografia;

    LocalDateTime fechaRegistrada;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Modalidad modalidad_evento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;

}
