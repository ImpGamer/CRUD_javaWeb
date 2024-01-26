package com.myweb.stWeb_dinamica.services.impl;

import com.myweb.stWeb_dinamica.entities.Persona;
import com.myweb.stWeb_dinamica.repositories.PersonaRepository;
import com.myweb.stWeb_dinamica.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Aqui se le aplica logica a los metodos de la interfaz
@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public List<Persona> obtenerTodas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona obtenerporID(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public void crearPersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void actualizarPersona(Long id, Persona persona) {
        Persona personaBBDD = personaRepository.findById(id).orElse(null);
        if(personaBBDD != null) {
            personaBBDD.setNombre(persona.getNombre());
            personaBBDD.setEdad(persona.getEdad());
            personaRepository.save(personaBBDD);
        }
    }

    @Override
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public long contarPersonas() {
        return personaRepository.count();
    }
}