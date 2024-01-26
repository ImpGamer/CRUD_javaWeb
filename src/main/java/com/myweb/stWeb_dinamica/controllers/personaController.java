package com.myweb.stWeb_dinamica.controllers;

import com.myweb.stWeb_dinamica.entities.Persona;
import com.myweb.stWeb_dinamica.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/personas")
public class personaController {
    @Autowired
    private PersonaService personaService;
    /*
    * La funcion usa un parametro de tipo Model, ya que el model sirve para transferir
    * datos y objetos a un archivo HTML, es decir como arquitectura MVC se encarga que el
    * controlador le pase la informacion a la vista o UI
     */
    @GetMapping
    public String listarPersonas(Model model) {
        List<Persona> personas = personaService.obtenerTodas();
        model.addAttribute("listaPersonas",personas); //El dato de tipo String es su identificador del UI
        return "listar";
    }
    //Metodo para abrir el formulario
    @GetMapping("/nuevo")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("persona",new Persona());
        model.addAttribute("accion","/personas/nuevo");
        return "formulario";
    }
    @PostMapping("/nuevo")
    public String guardarPersona(@ModelAttribute Persona persona) {
        personaService.crearPersona(persona);
        return "redirect:/personas";
    }
    /*
    * Anotacion @PathVariable para pasar variables o parametros mediante la URL
    * y capturarlas en el controlador al igual que al endpoint se debe indicar que
    * variable se le pasara como en este caso agarraremos el ID.
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id,@ModelAttribute Persona persona,Model model) {
        model.addAttribute("persona",persona);
        model.addAttribute("accion","/personas/editar/"+id);
        return "formulario";
    }
    @PostMapping("/editar/{id}")
    public String actualizarPersona(@PathVariable Long id,@ModelAttribute Persona persona) {
        personaService.actualizarPersona(id,persona);
        return "redirect:/personas";
    }
    @GetMapping("/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
        return "redirect:/personas";
    }

}