package org.maroxa.gce.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.Alumno;

public class MostrarAlumnosAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<Alumno> listaDeAlumnos = Alumno.buscarTodos();
        List<String> listaDeCursos = Alumno.buscarTodosLosCursos();
        request.setAttribute("listaDeAlumnos", listaDeAlumnos);
        request.setAttribute("listaDeCursos", listaDeCursos);
        return "mostrarAlumnos.jsp";
    }

}
