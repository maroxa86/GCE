package org.maroxa.gce.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.bo.Curso;
import org.maroxa.gce.dao.CursoDAO;
import org.maroxa.gce.dao.impl.CursoDAOImpl;

public class AltaAlumnoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        CursoDAO cursoDAO = new CursoDAOImpl();
        List<Curso> listaDeCursos = cursoDAO.buscarTodos();
        request.setAttribute("listaDeCursos", listaDeCursos);
        return "altaAlumno.jsp";
    }

}
