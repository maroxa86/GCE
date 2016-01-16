package org.maroxa.gce.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.dao.AlumnoDAO;
import org.maroxa.gce.factory.DAOAbstractFactory;
import org.maroxa.gce.factory.DAOFactory;

public class BorrarAlumnoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        DAOFactory factory = DAOAbstractFactory.getInstance();
        AlumnoDAO alumnoDAO = factory.getAlumnoDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Alumno alumno = new Alumno(id);
        alumnoDAO.borrar(alumno);
        return "mostrarAlumnos.do";
    }
}
