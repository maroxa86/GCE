package org.maroxa.gce.servicios.impl;

import java.util.List;

import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.bo.Curso;
import org.maroxa.gce.dao.AlumnoDAO;
import org.maroxa.gce.dao.CursoDAO;
import org.maroxa.gce.servicios.ServicioAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="servicioAlumno")
public class ServicioAlumnoImpl implements ServicioAlumno{

    
    private AlumnoDAO alumnoDAO;
    
    private CursoDAO cursoDAO;
    
    public ServicioAlumnoImpl(){
        super();
    }
    
    public AlumnoDAO getAlumnoDAO() {
        return alumnoDAO;
    }
    @Autowired
    public void setAlumnoDAO(AlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }

    public CursoDAO getCursoDAO() {
        return cursoDAO;
    }
    @Autowired
    public void setCursoDAO(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    @Override
    @Transactional
    public void salvarAlumno(Alumno alumno) {
        alumnoDAO.salvar(alumno);
        
    }

    @Override
    @Transactional
    public void borrarAlumno(Alumno alumno) {
        alumnoDAO.borrar(alumno);
        
    }
    @Override
    @Transactional
    public void insertarAlumno(Alumno alumno){
        alumnoDAO.insertar(alumno);
    }
    
    @Override
    public List<Alumno> buscarTodosLosAlumno() {
        return this.alumnoDAO.buscarTodos();
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
