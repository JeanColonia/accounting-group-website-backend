package com.grupocontable.website.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_usuario")
    Integer idUsuario;

    String nombres;
    String apellidos;
    String email;

    @Column(name ="nombre_usuario")
    String nombreUsuario;
    @Column(name ="tipo_usuario")
    String tipoUsuario;
    @Column(name ="pass")
    String pass;

    Boolean activo;

    String imagenUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Evento> evento = new LinkedHashSet<>();
}
