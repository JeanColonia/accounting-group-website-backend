package com.grupocontable.website.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer idMail;
    String fromEmail;
    String subject;
    String body;
}
