package org.maroxa.gce.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.Alumno;

public class FiltrarAlumnosAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<Alumno> listaDeAlumnos = null;
        List<String> listaDeCursos = Alumno.buscarTodosLosCursos();
        if (request.getParameter("curso") == null 
                || request.getParameter("curso").equals("seleccionar")) {
            listaDeAlumnos = Alumno.buscarTodos();
        } else {
            listaDeAlumnos = Alumno.buscarPorCurso(request.getParameter("curso"));
        }
        request.setAttribute("listaDeAlumnos", listaDeAlumnos);
        request.setAttribute("listaDeCursos", listaDeCursos);
        return "mostrarAlumnos.jsp";
    }

}
