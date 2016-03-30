package org.maroxa.gce.bo.impl;

import java.util.List;

import org.maroxa.gce.bean.Alumno;
import org.maroxa.gce.bean.Curso;
import org.maroxa.gce.bo.AlumnoBO;
import org.maroxa.gce.dao.AlumnoDAO;
import org.maroxa.gce.dao.CursoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase encargada de implementar los métodos descritos en la interfaz AlumnoBO
 * @author Xavi
 *
 */
//Indica que esta clase es servicio para que lo pueda injectar Spring
@Service(value="alumnoBO")
public class AlumnoBOImpl implements AlumnoBO{
    
    private AlumnoDAO alumnoDAO;
    
    private CursoDAO cursoDAO;
    
    /**
     * Constructror generico de la clase
     */
    public AlumnoBOImpl(){
        super();
    }
    
    public AlumnoDAO getAlumnoDAO() {
        return alumnoDAO;
    }
    
    //Anotación para injectar un bean de Spring 
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

    /* (non-Javadoc)
     * @see org.maroxa.gce.bo.AlumnoBO#salvarAlumno(org.maroxa.gce.bean.Alumno)
     */
    @Override
    //Indica que el método es transacitional
    @Transactional
    public void salvarAlumno(Alumno alumno) {
        alumnoDAO.salvar(alumno);
        
    }

    /* (non-Javadoc)
     * @see org.maroxa.gce.bo.AlumnoBO#borrarAlumno(org.maroxa.gce.bean.Alumno)
     */
    @Override
    @Transactional
    public void borrarAlumno(Alumno alumno) {
        alumnoDAO.borrar(alumno);
        
    }
    /* (non-Javadoc)
     * @see org.maroxa.gce.bo.AlumnoBO#insertarAlumno(org.maroxa.gce.bean.Alumno)
     */
    @Override
    @Transactional
    public void insertarAlumno(Alumno alumno){
        alumnoDAO.insertar(alumno);
    }
    
    /* (non-Javadoc)
     * @see org.maroxa.gce.bo.AlumnoBO#buscarTodosLosAlumno()
     */
    @Override
    public List<Alumno> buscarTodosLosAlumno() {
        return this.alumnoDAO.buscarTodos();
    }

    /* (non-Javadoc)
     * @see org.maroxa.gce.bo.AlumnoBO#buscarCursos()
     */
    @Override
    public List<Curso> buscarCursos() {
        return cursoDAO.buscarTodos();
    }

    /* (non-Javadoc)
     * @see org.maroxa.gce.bo.AlumnoBO#buscarAlumnoPorClave(int)
     */
    @Override
    public Alumno buscarAlumnoPorClave(int id) {
        return alumnoDAO.buscarPorClave(id);
    }

    /* (non-Javadoc)
     * @see org.maroxa.gce.bo.AlumnoBO#buscarCursoPorClave(int)
     */
    @Override
    public Curso buscarCursoPorClave(int id) {
       return cursoDAO.buscarPorClave(id);
    }

    /* (non-Javadoc)
     * @see org.maroxa.gce.bo.AlumnoBO#buscarAumnosPorCurso(org.maroxa.gce.bean.Curso)
     */
    @Override
    public List<Alumno> buscarAumnosPorCurso(Curso curso) {
        return alumnoDAO.buscarPorCurso(curso);
    }
}
