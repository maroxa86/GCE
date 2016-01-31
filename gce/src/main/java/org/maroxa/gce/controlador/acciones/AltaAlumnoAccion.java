package org.maroxa.gce.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.bo.Curso;
import org.maroxa.gce.servicios.ServicioAlumno;

public class AltaAlumnoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        ServicioAlumno servicioAlumno = (ServicioAlumno)getBean("servicioAlumno", request);
        List<Curso> listaDeCursos = servicioAlumno.buscarCursos();
        request.setAttribute("listaDeCursos", listaDeCursos);
        return "altaAlumno.jsp";
    }
}
