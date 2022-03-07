package com.grupocontable.website.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Capacitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_capacitacion")
    Integer idCapacitacion;

    @Column(name="titulo")
    String titulo;
    @Column(name="tipo_capacitacion")
    String tipoCapacitacion;
    @Column(name="fecha")
    String fecha;
    @Column(name="descripcion")
    String descripcion;
    @Column(name="fg_virtual")
    String fgVirtual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_idservicio")
    private Servicio servicio;
}
