package com.grupocontable.website.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Temario implements Serializable {
    @Id
     @Column(name="id_temario")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idTemario;

    @Column(name="titulo")
    String titulo;
    @Column(name="descripcion")
    String descripcion;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="fk_id_capacitacion")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Capacitacion capacitacion;
}
