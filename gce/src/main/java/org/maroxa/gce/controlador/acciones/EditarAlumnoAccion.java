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

public class EditarAlumnoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        DAOFactory factory = DAOAbstractFactory.getInstance();
        CursoDAO cursoDAO = factory.getCursoDAO();
        AlumnoDAO alumnoDAO = factory.getAlumnoDAO();
        List<Curso> listaDeCursos = cursoDAO.buscarTodos();
        int id = Integer.parseInt(request.getParameter("id"));
        Alumno alumno = alumnoDAO.buscarPorClave(id);
        request.setAttribute("listaDeCursos", listaDeCursos);
        request.setAttribute("alumno", alumno);
        return "editarAlumno.jsp";
    }
}
