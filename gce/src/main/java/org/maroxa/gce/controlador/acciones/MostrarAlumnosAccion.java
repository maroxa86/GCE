package org.maroxa.gce.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.bo.Curso;
import org.maroxa.gce.servicios.ServicioAlumno;

public class MostrarAlumnosAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        ServicioAlumno servicioAlumno = (ServicioAlumno)getBean("servicioAlumno", request);
        List<Alumno> listaDeAlumnos = servicioAlumno.buscarTodosLosAlumno();
        List<Curso> listaDeCursos = servicioAlumno.buscarCursos();
        request.setAttribute("listaDeAlumnos", listaDeAlumnos);
        request.setAttribute("listaDeCursos", listaDeCursos);
        return "mostrarAlumnos.jsp";
    }
}
