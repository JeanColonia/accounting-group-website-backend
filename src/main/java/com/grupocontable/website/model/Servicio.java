package com.grupocontable.website.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_servicio")
    Integer idServicio;
    
    @Column(name="fotografia")
    String fotografia;
    @Column(name="titulo")
    String titulo;
    @Column(name="tipo")
    String tipo;
    @Column(name="fecha")
    String fecha;
    @Column(name="descripcion")
    String descripcion;
    @Column(name="fg_virtual")
    String fgVirtual;

//    @OneToMany(mappedBy = "servicio");
 //   Set<PersonalServicio> lista;
}

