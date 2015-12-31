package org.maroxa.gce.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.Alumno;

public class EditarAlumnoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        List<String> listaDeCursos = Alumno.buscarTodosLosCursos();
        request.setAttribute("listaDeCursos", listaDeCursos);
        Alumno alumno = Alumno.buscarAlumnoPorClave(id);
        request.setAttribute("alumno", alumno);
        return "editarAlumno.jsp";
    }

}
