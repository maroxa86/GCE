package org.maroxa.gce.servicios;

import java.util.List;

import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.bo.Curso;

public interface ServicioAlumno {
    public void salvarAlumno(Alumno alumno);
    public void borrarAlumno(Alumno alumno);
    public void insertarAlumno(Alumno alumno);
    public List<Alumno> buscarTodosLosAlumno();
    public List<Curso> buscarCursos();
    public Alumno buscarAlumnoPorClave(int id);
    public Curso buscarCursoPorClave(int id);
    public List<Alumno> buscarAumnosPorCurso(Curso curso);
}
