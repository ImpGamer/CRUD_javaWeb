package com.myweb.stWeb_dinamica.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Table(name = "tbl_libros")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String titulo;
    private String genero;
    @NotNull
    private String autor;
    private int paginas;
}