package com.grupocontable.website.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cursos")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_curso")
    Integer idCurso;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String titulo;

    String fecha;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String imagen;

    @Column(name="hora_inicio")
    String horaInicio;
    @Column(name="hora_fin")
    String horaFin;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String descripcion;

    LocalDateTime fechaRegistrada;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String linkCarrito;


    String inversion;

    String estado;
    @ManyToOne(fetch = FetchType.EAGER)
    private Modalidad modalidad;
    @ManyToOne(fetch = FetchType.EAGER)
    private Docentes docente;

    @ManyToOne(fetch = FetchType.EAGER)
    private CategoriaCurso categoriacurso;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    /******* OBTENEMOS UN LISTADO DE TEMARIOS DEL CURSO CORRESPONDIENTE **************/
    @OneToMany( mappedBy= "curso", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JsonIgnore
    private Set<Temario> temario=new LinkedHashSet<>();

}
