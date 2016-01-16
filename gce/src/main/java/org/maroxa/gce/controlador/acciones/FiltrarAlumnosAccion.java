package org.maroxa.gce.controlador.acciones;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.bo.Curso;
import org.maroxa.gce.dao.AlumnoDAO;
import org.maroxa.gce.dao.CursoDAO;
import org.maroxa.gce.factory.DAOAbstractFactory;
import org.maroxa.gce.factory.DAOFactory;

public class FiltrarAlumnosAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        DAOFactory factory = DAOAbstractFactory.getInstance();
        CursoDAO cursoDAO = factory.getCursoDAO();
        AlumnoDAO alumnoDAO = factory.getAlumnoDAO();
        List<Alumno> listaDeAlumnos = new ArrayList<>();
        List<Curso> listaDeCursos = cursoDAO.buscarTodos();
        if (request.getParameter("curso") == null 
                || request.getParameter("curso").equals("seleccionar")) {
            listaDeAlumnos = alumnoDAO.buscarTodos();
            request.setAttribute("listaDeAlumnos", listaDeAlumnos);
        } else {
            Curso curso = new Curso(Integer.parseInt(request.getParameter("curso")));
            listaDeAlumnos = alumnoDAO.buscarPorCurso(curso);
            request.setAttribute("listaDeAlumnos", listaDeAlumnos);
        }
        
        request.setAttribute("listaDeCursos", listaDeCursos);
        return "mostrarAlumnos.jsp";
    }
}
