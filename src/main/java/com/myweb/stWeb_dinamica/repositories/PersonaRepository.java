package com.myweb.stWeb_dinamica.repositories;

import com.myweb.stWeb_dinamica.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * En los parametros para heredar de JpaRepository debemos pasar el nombre de la entidad,
 * es decir el nombre de la clase de la entidad, y luego el tipo de dato que tiene el ID,
 * en este caso posee Long, pero ya seria depende a el tipo de dato que le asignemos
 */

/**
 * El repository o repositorio heredara todas las funciones del JPA para interactuar
 * directamente con la base de datos mediante metodos sin necesidad de aplicar
 * lenguaje SQL
 */
@Repository //Esteorotipo Repository o Modelo
public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
