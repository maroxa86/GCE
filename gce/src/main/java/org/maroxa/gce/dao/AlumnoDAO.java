package org.maroxa.gce.dao;

import java.util.List;

import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.bo.Curso;

public interface AlumnoDAO extends GenericDAO<Alumno, Integer>{
    public List<Alumno> buscarPorCurso(Curso curso);
}
