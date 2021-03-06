package com.grupocontable.website.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Publicacion  {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_publicacion")
    private Integer idPublicacion;

    @Column(name="nombre")
    String nombre;
    @Column(name="fecha")
    String fecha;
    @Column(name="tipo_publicacion")
    String tipoPublicacion;
    @Column(name="imagen")
    String imagen;
    @Column(name="autor")
    String autor;
    @Column(name="cargo_autor")
    String cargoAutor;
    @Column(name="descripcion")
    String descripcion;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_idusuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    private Usuario usuario;

}
