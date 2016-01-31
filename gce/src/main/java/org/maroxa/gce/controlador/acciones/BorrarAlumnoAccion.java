package org.maroxa.gce.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.servicios.ServicioAlumno;

public class BorrarAlumnoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        ServicioAlumno servicioAlumno = (ServicioAlumno)getBean("servicioAlumno", request);
        int id = Integer.parseInt(request.getParameter("id"));
        Alumno alumno = new Alumno(id);
        servicioAlumno.borrarAlumno(alumno);
        return "mostrarAlumnos.do";
    }
}
