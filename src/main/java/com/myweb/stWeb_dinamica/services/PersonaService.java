package com.myweb.stWeb_dinamica.services;

import com.myweb.stWeb_dinamica.entities.Persona;
import java.util.List;

/*
* Service = Controlador MVC
* El service se encargara de realizar las operaciones de negocio agarrando datos y
* manipulandolos o comparandolos para aplicar una cierta condicion dentro de la logica
* este tendra una dependencia la cual sera el Repository.
 */
//Aqui se declaran sus metodos
public interface PersonaService {

    List<Persona> obtenerTodas();
    Persona obtenerporID(Long id);
    void crearPersona(Persona persona);
    void actualizarPersona(Long id, Persona persona);
    void eliminarPersona(Long id);
    long contarPersonas();

}
