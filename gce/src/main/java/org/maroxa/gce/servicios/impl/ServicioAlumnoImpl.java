package org.maroxa.gce.servicios.impl;

import java.util.List;

import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.bo.Curso;
import org.maroxa.gce.dao.AlumnoDAO;
import org.maroxa.gce.dao.CursoDAO;
import org.maroxa.gce.factory.DAOAbstractFactory;
import org.maroxa.gce.factory.DAOFactory;
import org.maroxa.gce.servicios.ServicioAlumno;

public class ServicioAlumnoImpl implements ServicioAlumno{

    private AlumnoDAO alumnoDAO;
    private CursoDAO cursoDAO;
    
    public ServicioAlumnoImpl(){
        super();
        DAOFactory factory = DAOAbstractFactory.getInstance();
        alumnoDAO = factory.getAlumnoDAO();
        cursoDAO = factory.getCursoDAO();
    }
    
    @Override
    public void salvarAlumno(Alumno alumno) {
        alumnoDAO.salvar(alumno);
        
    }

    @Override
    public void borrarAlumno(Alumno alumno) {
        alumnoDAO.borrar(alumno);
        
    }
    @Override
    public void insertarAlumno(Alumno alumno){
        alumnoDAO.insertar(alumno);
    }
    
    @Override
    public List<Alumno> buscarTodosLosAlumno() {
        return alumnoDAO.buscarTodos();
    }

    @Override
    public List<Curso> buscarCursos() {
        return cursoDAO.buscarTodos();
    }

    @Override
    public Alumno buscarAlumnoPorClave(int id) {
        return alumnoDAO.buscarPorClave(id);
    }

    @Override
    public Curso buscarCursoPorClave(int id) {
       return cursoDAO.buscarPorClave(id);
    }

    @Override
    public List<Alumno> buscarAumnosPorCurso(Curso curso) {
        return alumnoDAO.buscarPorCurso(curso);
    }

}
