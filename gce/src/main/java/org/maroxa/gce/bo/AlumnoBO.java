package org.maroxa.gce.bo;

import java.util.List;

import org.maroxa.gce.bean.Alumno;
import org.maroxa.gce.bean.Curso;

/**
 * Interfaz de negoció con los funciones que se pueden realizar con los alumnos
 * @author Xavi
 */
public interface AlumnoBO {
    /**
     * Guarda la información modificada de un alumno
     * @param alumno Información actualizada del alumno a modificar
     */
    void salvarAlumno(Alumno alumno);
    
    /**
     * Elimina un alumno de la aplicación
     * @param alumno Información del alumno a eliminar
     */
    void borrarAlumno(Alumno alumno);
    
    /**
     * Añade un nuevo alumno a la aplicación
     * @param alumno Información del alumno a insertar
     */
    void insertarAlumno(Alumno alumno);
    
    /**
     * Busca todos los alumnos que hay en el sistema
     * @return Lista de alumnos de la aplicación
     */
    List<Alumno> buscarTodosLosAlumno();
    
    /**
     * Busca los cursos que hay en el sistema
     * @return Lista de Cursos de la aplicación
     */
    List<Curso> buscarCursos();
    
    /**
     * Se busca la información de un alumno por su identificador
     * @param id Identificador del alumno a buscar
     * @return Información del alumno buscado
     */
    Alumno buscarAlumnoPorClave(int id);
    
    /**
     * Busca un curso por su identificador
     * @param id Identificador del curso
     * @return Información del curso buscado
     */
    Curso buscarCursoPorClave(int id);
    
    /**
     * Busca los alumnos que pertenecen a un curso
     * @param curso Identificador del curso que se quiere buscar
     * @return Lista de alumnos que pertenecen al curso buscado
     */
    List<Alumno> buscarAumnosPorCurso(Curso curso);
}
