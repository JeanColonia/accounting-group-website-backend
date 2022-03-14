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
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Usuario   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_usuario")
    Integer idUsuario;
    @Column(name ="nombre_usuario")
    String nombreUsuario;
    @Column(name ="tipo_usuario")
    String tipoUsuario;
    @Column(name ="pass")
    String pass;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="fk_idpersonal")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    private Personal personal;

}
