package org.maroxa.gce.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.bo.Curso;
import org.maroxa.gce.dao.AlumnoDAO;
import org.maroxa.gce.dao.impl.AlumnoDAOImpl;
import org.maroxa.gce.dao.impl.CursoDAOImpl;

public class MostrarAlumnosAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        AlumnoDAO alumnoDAO = new AlumnoDAOImpl();
        CursoDAOImpl cursoDAO = new CursoDAOImpl();
        List<Alumno> listaDeAlumnos = alumnoDAO.buscarTodos();
        List<Curso> listaDeCursos = cursoDAO.buscarTodos();
        request.setAttribute("listaDeAlumnos", listaDeAlumnos);
        request.setAttribute("listaDeCursos", listaDeCursos);
        return "mostrarAlumnos.jsp";
    }

}
