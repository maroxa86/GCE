package org.maroxa.gce.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.maroxa.gce.Constantes;
import org.maroxa.gce.JPAHelper;
import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.bo.Curso;
import org.maroxa.gce.dao.AlumnoDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AlumnoDAOImpl extends GenericDAOImpl<Alumno, Integer> implements AlumnoDAO{
    
    private static final Logger LOGGER = Logger.getLogger(AlumnoDAOImpl.class);
    
    @Override
    @Transactional(readOnly=true)
    public List<Alumno> buscarTodos(){
        LOGGER.info(Constantes.INICIO_LOG + " buscarPorCurso");
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        TypedQuery<Alumno> consulta = manager.createQuery("SELECT alumno FROM Alumno alumno JOIN FETCH alumno.curso", Alumno.class);
        List<Alumno> listaDeAlumnos = null;
        try{
            listaDeAlumnos = consulta.getResultList();
        }
        finally{            
            manager.close();
        }
        LOGGER.info(Constantes.FIN_LOG + " buscarPorCurso");
        return listaDeAlumnos;
    }
    
    @Transactional(readOnly=true)
    public List<Alumno> buscarPorCurso(Curso curso){
        LOGGER.info(Constantes.INICIO_LOG + " buscarPorCurso");
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        TypedQuery<Alumno> consulta = manager.createQuery("SELECT alumno FROM Alumno alumno where alumno.curso=?1", Alumno.class);
        List<Alumno> listaDeAlumnos = null;
        try{
            consulta.setParameter(1, curso);
            listaDeAlumnos = consulta.getResultList();
        }
        finally{            
            manager.close();
        }
        LOGGER.info(Constantes.FIN_LOG + " buscarPorCurso");
        return listaDeAlumnos;
    }
}
