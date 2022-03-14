package com.grupocontable.website.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name="items_temario")
public class ItemsTemario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_item_temario")
    Integer idItemTemario;

    @Column(name="titulo_item")
    String tituloItem;
    @Column(name="descripcion_item")
    String descripcionItem;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_id_temario")
    @ToString.Exclude
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Temario temario;

}
