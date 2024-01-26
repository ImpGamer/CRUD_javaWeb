package com.myweb.stWeb_dinamica.controllers;

import com.myweb.stWeb_dinamica.entities.Libro;
import com.myweb.stWeb_dinamica.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/libros")
public class libroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public String mostrarLibros(Model model) {
        List<Libro> libros = libroService.mostrarLibros();
        Long cantLibros = libroService.cantidadLibros();

        model.addAttribute("librosReg",libros);
        model.addAttribute("cantLibros",cantLibros);
        return "librosLista";
    }
    @GetMapping("/nuevo")
    public String formularioLibro(Model model) {
        model.addAttribute("libro",new Libro());
        model.addAttribute("direccion","/libros/nuevo");

        return "formularioLibro";
    }

    @PostMapping("/nuevo")
    public String agregarLibro(@ModelAttribute Libro libro,Model model) {
        try {
            libroService.agregarLibro(libro);
        } catch (Exception e) {
            String error = e.getMessage();
            model.addAttribute("error",error);

            return "formularioLibro";
        }
        return "redirect:/libros";
    }
    @GetMapping("/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return "redirect:/libros";
    }
    @GetMapping("/editar/{id}")
    public String fomularioEditar(@PathVariable Long id,@ModelAttribute Libro libro,Model model) {
        model.addAttribute("libro",libro);
        model.addAttribute("direccion","/libros/editar/"+id);
        return "editarLibro";
    }
    @PostMapping("/editar/{id}")
    public String editarLibro(@PathVariable Long id,@ModelAttribute Libro libro,Model model) {
        try {
            libroService.actualizarLibro(id,libro);
        }catch (Exception e) {
            String error = e.getMessage();
            model.addAttribute("error",error);

            return "editarLibro";
        }
        return "redirect:/libros";
    }

}