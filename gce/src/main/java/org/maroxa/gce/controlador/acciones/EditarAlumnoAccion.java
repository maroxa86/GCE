package org.maroxa.gce.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.bo.Curso;
import org.maroxa.gce.servicios.ServicioAlumno;

public class EditarAlumnoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        ServicioAlumno servicioAlumno = (ServicioAlumno)getBean("servicioAlumno", request);
        List<Curso> listaDeCursos = servicioAlumno.buscarCursos();
        int id = Integer.parseInt(request.getParameter("id"));
        Alumno alumno = servicioAlumno.buscarAlumnoPorClave(id);
        request.setAttribute("listaDeCursos", listaDeCursos);
        request.setAttribute("alumno", alumno);
        return "editarAlumno.jsp";
    }
}
