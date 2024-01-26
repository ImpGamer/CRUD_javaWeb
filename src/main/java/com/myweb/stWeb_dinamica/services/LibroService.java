package com.myweb.stWeb_dinamica.services;

import com.myweb.stWeb_dinamica.entities.Libro;

import java.util.List;

public interface LibroService {
    void agregarLibro(Libro libro) throws Exception;
    void eliminarLibro(Long id);
    List<Libro> mostrarLibros();
    List<Libro> buscarLibro_Titulo_Autor(String titulo,String autor);
    long cantidadLibros();
    Libro buscarLibroID(Long id);
    void actualizarLibro(Long id,Libro libro) throws Exception;
}
