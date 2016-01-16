package org.maroxa.gce.factory.impl;

import org.maroxa.gce.dao.AlumnoDAO;
import org.maroxa.gce.dao.CursoDAO;
import org.maroxa.gce.dao.impl.AlumnoDAOImpl;
import org.maroxa.gce.dao.impl.CursoDAOImpl;
import org.maroxa.gce.factory.DAOFactory;

public class DAOFactoryImpl implements DAOFactory{
    @Override
    public CursoDAO getCursoDAO(){
        return new CursoDAOImpl();
    }
    
    @Override
    public AlumnoDAO getAlumnoDAO(){
        return new AlumnoDAOImpl();
    }
}
