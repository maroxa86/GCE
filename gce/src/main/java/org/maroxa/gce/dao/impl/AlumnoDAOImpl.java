package org.maroxa.gce.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.maroxa.gce.Constantes;
import org.maroxa.gce.bean.Alumno;
import org.maroxa.gce.bean.Curso;
import org.maroxa.gce.dao.AlumnoDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase encargada interactuar con la base de datos con la tabla Alumnos 
 * implementando los metodos de la interfaz AlumnoDAO
 * Extiende la clase GenericDAOImpl
 * @author Xavi
 *
 */
//Añade al repositorio de Spring para poder injectar la clase.
@Repository
public class AlumnoDAOImpl extends AbstractGenericDAOImpl<Alumno, Integer> implements AlumnoDAO{
    
    private static final Logger LOGGER = Logger.getLogger(AlumnoDAOImpl.class);
          
    /* (non-Javadoc)
     * @see org.maroxa.gce.dao.AlumnoDAO#buscarPorCurso(org.maroxa.gce.bean.Curso)
     */
    @Override
    @Transactional(readOnly=true)
    public List<Alumno> buscarPorCurso(Curso curso){
        LOGGER.info(Constantes.INICIO_LOG + " buscarPorCurso");
        TypedQuery<Alumno> consulta = 
                getManager().createQuery("SELECT alumno FROM Alumno alumno where alumno.curso=?1", Alumno.class);
        consulta.setParameter(1, curso);
        LOGGER.info(Constantes.FIN_LOG + " buscarPorCurso");
        return consulta.getResultList();
    }
}
