package org.maroxa.gce.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.bo.Alumno;

public class AltaAlumnoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<String> listaDeCursos = Alumno.buscarTodosLosCursos();
        request.setAttribute("listaDeCursos", listaDeCursos);
        return "altaAlumno.jsp";
    }

}
