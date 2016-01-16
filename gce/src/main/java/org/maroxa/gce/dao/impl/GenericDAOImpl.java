package org.maroxa.gce.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.maroxa.gce.JPAHelper;
import org.maroxa.gce.dao.GenericDAO;
import org.maroxa.gce.exception.GceException;

public class GenericDAOImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

    private Class<T> claseDePersistencia;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
        this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    public T buscarPorClave(Id id) {
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        T objeto = null;
        try {
            objeto = (T) manager.find(claseDePersistencia, id);
        } finally {
            manager.close();
        }
        return objeto;
    }

    @Override
    public List<T> buscarTodos() {
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        List<T> listaDeObjetos = null;
        try {
            TypedQuery<T> consulta = manager.createQuery("select o from " + claseDePersistencia.getSimpleName() + " o",
                    claseDePersistencia);
            listaDeObjetos = consulta.getResultList();
            return listaDeObjetos;
        } finally {
            manager.close();
        }
    }

    @Override
    public void borrar(T objeto) {
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = manager.getTransaction();
            tx.begin();
            manager.remove(manager.merge(objeto));
            tx.commit();
        } catch (PersistenceException e) {
            tx.rollback();
            throw new GceException(e.getMessage(),e);
        } finally {
            manager.close();
        }
    }
    @Override
    public void salvar(T objeto) {
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = manager.getTransaction();
            tx.begin();
            manager.merge(objeto);
            tx.commit();
        } catch (PersistenceException e) {
            tx.rollback();
            throw new GceException(e.getMessage(),e);
        } finally {
            manager.close();
        }
    }
    @Override
    public void insertar(T objeto) {
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = manager.getTransaction();
            tx.begin();
            manager.persist(objeto);
            tx.commit();
        } catch (PersistenceException e) {
            tx.rollback();
            throw new GceException(e.getMessage(),e);
        } finally {
            manager.close();
        }
    }

}
