package org.maroxa.gce.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.maroxa.gce.dao.GenericDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase Abstacta con la implementación de los métodos de la interfaz GenericDAO
 * @author Xavi
 *
 * @param <T> Tipo de Objeto con el que se va a trabajar
 * @param <E> Tipo de dato del identificador de la clase a trabajar
 */
@Repository
public abstract class AbstractGenericDAOImpl<T, E extends Serializable> implements GenericDAO<T, E> {

    //Clase a persisterir
    private Class<T> claseDePersistencia;
    
    //Obtiene el EntityManager del contexto de persistencia
    @PersistenceContext
    private EntityManager manager;
       
    /**
     *Constructor de la clase que extrae la información de la clase a trabajar 
     */
    @SuppressWarnings("unchecked")
    public AbstractGenericDAOImpl() {
        this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    /* (non-Javadoc)
     * @see org.maroxa.gce.dao.GenericDAO#buscarPorClave(java.io.Serializable)
     */
    @Override
    @Transactional(readOnly=true)
    public T buscarPorClave(E id) {
        return manager.find(claseDePersistencia, id);
    }

    /* (non-Javadoc)
     * @see org.maroxa.gce.dao.GenericDAO#buscarTodos()
     */
    @Override
    @Transactional(readOnly=true)
    public List<T> buscarTodos() {
        TypedQuery<T> consulta = (TypedQuery<T>) manager.createQuery("select o from " + 
                                                    claseDePersistencia.getSimpleName() + " o", claseDePersistencia);
        return consulta.getResultList();
    }
    
    /* (non-Javadoc)
     * @see org.maroxa.gce.dao.GenericDAO#borrar(java.lang.Object)
     */
    @Override
    @Transactional
    public void borrar(T objeto) {
        manager.remove(manager.merge(objeto));
    }
    /* (non-Javadoc)
     * @see org.maroxa.gce.dao.GenericDAO#salvar(java.lang.Object)
     */
    @Override
    @Transactional
    public void salvar(T objeto) {
        manager.merge(objeto);
    }
    /* (non-Javadoc)
     * @see org.maroxa.gce.dao.GenericDAO#insertar(java.lang.Object)
     */
    @Override
    @Transactional
    public void insertar(T objeto) {
        manager.persist(objeto);
    }
}
