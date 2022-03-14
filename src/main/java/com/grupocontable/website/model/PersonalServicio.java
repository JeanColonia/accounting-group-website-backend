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
public class PersonalServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_personalservicio")
    Integer idPersonalServicio;

    @ManyToOne
    @JoinColumn(name ="fk_idpersonal")
    private Personal personal;

    @ManyToOne
    @JoinColumn(name ="fk_idservicio")
    private Servicio servicio;

}
