package com.grupocontable.website.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Temario  {
    @Id
     @Column(name="id_temario")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idTemario;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String titulo;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String descripcionTemario;

    @ManyToOne(fetch= FetchType.EAGER)
    private Curso curso;

}
