package org.maroxa.gce.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.bo.Curso;
import org.maroxa.gce.servicios.ServicioAlumno;
import org.maroxa.gce.servicios.impl.ServicioAlumnoImpl;

public class AltaAlumnoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        ServicioAlumno servicioAlumno = new ServicioAlumnoImpl();
        List<Curso> listaDeCursos = servicioAlumno.buscarCursos();
        request.setAttribute("listaDeCursos", listaDeCursos);
        return "altaAlumno.jsp";
    }
}
