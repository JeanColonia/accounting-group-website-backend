package com.grupocontable.website.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Blog {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_blog")
    private Integer idBlog;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String titulo;

    @Column(name="fecha")
    String fecha;

    @Column(name="tipo_publicacion")
    String tipoPublicacion;

    @Column(name="imagen")
    String imagen;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String descripcion;

    LocalDateTime fechaRegistrada;

    String estado;
    boolean mostrarAutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;




}
