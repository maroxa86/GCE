package org.maroxa.gce.dao;

import java.util.List;

import org.maroxa.gce.bean.Alumno;
import org.maroxa.gce.bean.Curso;

/**
 * Interfaz que describe los métodos que interaccionan con la clase de mapeo Alumno.
 * Esta clase extiende la clase GenericDAO
 * @author Xavi
 *
 */
public interface AlumnoDAO extends GenericDAO<Alumno, Integer>{
    /**
     * Busca los alumnos que pertenecen a un curso concreto
     * @param curso Información del curso a buscar
     * @return Lista de alumnos que pertencen al curso
     */
    List<Alumno> buscarPorCurso(Curso curso);
}
