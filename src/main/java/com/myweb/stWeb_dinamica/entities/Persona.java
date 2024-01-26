package com.myweb.stWeb_dinamica.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
* Los Entity o entidades son objetos que seran marcados como tablas dentro de una
* BD utilizando un ORM, en este caso esta clase "Persona" sera una tabla SQL llamada
* "tbl_personas" donde sus valores o columnas seran los atributos e
 */
//Etiqueta @Entity para marcar al JPA que se trata de una entidad que creara una tabla dentro de nuestra DB
@Entity
@Table(name = "tbl_personas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int edad;
}