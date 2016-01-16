package org.maroxa.gce.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.bo.Curso;
import org.maroxa.gce.dao.AlumnoDAO;
import org.maroxa.gce.dao.CursoDAO;
import org.maroxa.gce.factory.DAOAbstractFactory;
import org.maroxa.gce.factory.DAOFactory;

public class MostrarAlumnosAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        DAOFactory factory = DAOAbstractFactory.getInstance();
        CursoDAO cursoDAO = factory.getCursoDAO();
        AlumnoDAO alumnoDAO = factory.getAlumnoDAO();
        List<Alumno> listaDeAlumnos = alumnoDAO.buscarTodos();
        List<Curso> listaDeCursos = cursoDAO.buscarTodos();
        request.setAttribute("listaDeAlumnos", listaDeAlumnos);
        request.setAttribute("listaDeCursos", listaDeCursos);
        return "mostrarAlumnos.jsp";
    }
}
