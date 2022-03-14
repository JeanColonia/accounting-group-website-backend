package com.grupocontable.website.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonalCapacitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_personalcapacitacion")
    Integer idPersonalCapacitacion;

    @ManyToOne
    @JoinColumn(name ="fk_id_personal")
    private Personal personal;

    @ManyToOne
    @JoinColumn(name ="fk_id_capacitacion")
    private Capacitacion capacitacion;

}
