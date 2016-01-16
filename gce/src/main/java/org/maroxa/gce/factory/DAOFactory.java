package org.maroxa.gce.factory;

import org.maroxa.gce.dao.AlumnoDAO;
import org.maroxa.gce.dao.CursoDAO;

public interface DAOFactory {
    public CursoDAO getCursoDAO();
    public AlumnoDAO getAlumnoDAO();
}
