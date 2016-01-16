package org.maroxa.gce.controlador.acciones;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.bo.Curso;
import org.maroxa.gce.servicios.ServicioAlumno;
import org.maroxa.gce.servicios.impl.ServicioAlumnoImpl;

public class FiltrarAlumnosAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        ServicioAlumno servicioAlumno = new ServicioAlumnoImpl();
        List<Alumno> listaDeAlumnos = new ArrayList<>();
        List<Curso> listaDeCursos = servicioAlumno.buscarCursos();
        if (request.getParameter("curso") == null 
                || request.getParameter("curso").equals("seleccionar")) {
            listaDeAlumnos = servicioAlumno.buscarTodosLosAlumno();
            request.setAttribute("listaDeAlumnos", listaDeAlumnos);
        } else {
            Curso curso = new Curso(Integer.parseInt(request.getParameter("curso")));
            listaDeAlumnos = servicioAlumno.buscarAumnosPorCurso(curso);
            request.setAttribute("listaDeAlumnos", listaDeAlumnos);
        }
        
        request.setAttribute("listaDeCursos", listaDeCursos);
        return "mostrarAlumnos.jsp";
    }
}
