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
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Usuario implements Serializable {

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
     private Personal personal;
}
