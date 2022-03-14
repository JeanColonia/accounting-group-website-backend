package com.grupocontable.website.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    @Column(name="beneficios")
    String beneficios;
    @Column(name="inversion_presencial")
    String inversionPresencial;
    @Column(name="inversion_virtual")
    String inversionVirtual;
    @Column(name="descuentos")
    String descuentos;
    @Column(name="dirigido_tipo_profesionales")
    String dirigidoTipoProfesionales;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_id_usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    private Usuario usuario;


    @OneToMany(cascade=CascadeType.ALL, mappedBy="capacitacion",
    orphanRemoval = true)
    private List<Temario> temario=new ArrayList<>();


}
