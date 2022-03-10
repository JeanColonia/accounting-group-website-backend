package com.grupocontable.website.model;

import com.fasterxml.jackson.annotation.JsonCreator;
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
    @Column(name="imagen")
    String imagen;
    @Column(name="fg_virtual")
    String fgVirtual;
    @Column(name="hora_inicio")
    String horaInicio;
    @Column(name="hora_fin")
    String horaFin;
    @Column(name="modalidad")
    String modalidad;
    @Column(name="introduccion")
    String introduccion;
    @Column(name="objetivo")
    String objetivo;
    @Column(name="metodologia")
    String metodologia;
    @Column(name="relatador")
    String relatador;
    @Column(name="descripcion_relatador")
    String descripcionRelatador;
    @Column(name="beneficios")
    String beneficios;
    @Column(name="inversion_presencial")
    String inversionPresencial;
    @Column(name="inversion_virtual")
    String inversionVirtual;
    @Column(name="descuentos")
    String descuentos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_id_usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;
}
