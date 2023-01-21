package com.grupocontable.website.model;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BannerHome {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idBanner;

    String imagen;

    boolean estadoImagen;

 }
