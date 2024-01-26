package com.myweb.stWeb_dinamica.services.impl;

import com.myweb.stWeb_dinamica.entities.Libro;
import com.myweb.stWeb_dinamica.repositories.LibroRepository;
import com.myweb.stWeb_dinamica.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroRepository libroRepository;
    @Override
    public void agregarLibro(Libro libro) throws Exception {
        if(libro.getAutor() != null && libro.getTitulo() != null && libro.getPaginas() > 0) {
            libroRepository.save(libro);
        } else {
            throw new Exception("No se a proporcionado suficiente informacion sobre el libro");
        }
    }

    @Override
    public Libro buscarLibroID(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public List<Libro> mostrarLibros() {
        return libroRepository.findAll();
    }

    @Override
    public List<Libro> buscarLibro_Titulo_Autor(String titulo, String autor) {
        List<Libro> libros = libroRepository.findAll();
        List<Libro> libroTitulo = new ArrayList<>();

        for(Libro libro: libros) {
            if(libro.getTitulo().equals(titulo) || libro.getAutor().equals(autor)) {
                libroTitulo.add(libro);
            }
        }
        return libroTitulo;
    }

    @Override
    public void actualizarLibro(Long id, Libro libro) throws Exception {
        if(libro.getAutor() != null && libro.getTitulo() != null && libro.getPaginas() > 0) {
            Libro nuevoLibro = libroRepository.findById(id).orElse(null);
            if(nuevoLibro != null) {
                nuevoLibro.setTitulo(libro.getTitulo());
                nuevoLibro.setAutor(libro.getAutor());
                nuevoLibro.setGenero(libro.getGenero());
                nuevoLibro.setPaginas(libro.getPaginas());
                libroRepository.save(nuevoLibro);
            } else {
                throw new Exception("No se a podido encontrar el ID del libro");
            }
        } else {
            throw new Exception("Se a proporcionado informacion erronea o incompleta");
        }
    }

    @Override
    public long cantidadLibros() {
        return libroRepository.count();
    }
}
