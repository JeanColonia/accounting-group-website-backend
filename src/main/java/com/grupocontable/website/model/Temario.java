package com.grupocontable.website.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Temario  {
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
    @ToString.Exclude
    @JsonBackReference
    private Capacitacion capacitacion;

    /*
    @OneToMany(cascade=CascadeType.ALL, mappedBy="temario", orphanRemoval = true)
    private List<ItemsTemario> itemTemario=new ArrayList<>();
*/

}
