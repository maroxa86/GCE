package org.maroxa.gce.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.maroxa.gce.Constantes;
import org.maroxa.gce.JPAHelper;

@Entity
@Table(name="Alumno")
public class Alumno {
    private static final Logger LOGGER = Logger.getLogger(Alumno.class);
    
    @Id
    private String id; 
    private String nombre;
    private String primerApellido;
    private String segundoApellido; 
    
    @ManyToOne
    @JoinColumn(name="curso")
    private Curso curso;

    public Alumno() {
        super();
    }

    public Alumno(String id) {
        super();
        this.id = id;
    }
    
    public Alumno(String id, String nombre, String primerApellido, String segundoApellido, Curso curso) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.curso = curso;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void insertar(){
        LOGGER.info(Constantes.INICIO_LOG + " insertar");
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        try{
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            manager.persist(this);
            tx.commit();
        }
        catch(PersistenceException e){
            manager.getTransaction().rollback();
            LOGGER.error(Constantes.ERROR_INSERTAR_ALUMNO);
            LOGGER.error(e.getMessage());
            throw e;
        }
        finally{
            manager.close();
        }
        LOGGER.info(Constantes.FIN_LOG + " insertar");
    }

    public static List<Alumno> buscarTodos(){
        LOGGER.info(Constantes.INICIO_LOG + " buscarTodos");
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        TypedQuery<Alumno> consulta = manager.createQuery("SELECT alumno FROM Alumno alumno join fetch alumno.curso", Alumno.class);
        List<Alumno> listaDeAlumnos = null;
        try{
         listaDeAlumnos = consulta.getResultList();
        }
        finally{
            manager.close();
        }
        LOGGER.info(Constantes.FIN_LOG + " buscarTodos");
        return listaDeAlumnos;
    }
    
    public void borrar(){
        LOGGER.info(Constantes.INICIO_LOG + " borrar");
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        try{
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            manager.remove(manager.merge(this));
            tx.commit();
        }
        catch(PersistenceException e){
            manager.getTransaction().rollback();
            LOGGER.error(Constantes.ERROR_BORRAR_ALUMNO);
            LOGGER.error(e.getMessage());
            throw e;
        }
        finally{
            manager.close();
        }
        LOGGER.info(Constantes.FIN_LOG + " borrar");
    }
    
    public static Alumno buscarAlumnoPorClave(String id){
        LOGGER.info(Constantes.INICIO_LOG + " buscarAlumnoPorClave");
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        TypedQuery<Alumno> consulta = manager.createQuery("SELECT alumno FROM Alumno alumno JOIN FETCH alumno.curso where alumno.id=?1", Alumno.class);
        Alumno alumno = null;
        try{
            consulta.setParameter(1, id);
            alumno = consulta.getSingleResult();
        }
        finally{
            manager.close();
        }
        LOGGER.info(Constantes.FIN_LOG + " buscarAlumnoPorClave");
        return alumno;
    }
    
    public void salvarAlumno(){
        LOGGER.info(Constantes.INICIO_LOG + " salvarAlumno");
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        try{
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            manager.merge(this);
            tx.commit();
        }
        catch(PersistenceException e){
            manager.getTransaction().rollback();
            LOGGER.error(Constantes.ERROR_MODIFICAR_ALUMNO);
            LOGGER.error(e.getMessage());
            throw e;
        }
        finally{
            manager.close();
        }
        LOGGER.info(Constantes.FIN_LOG + " salvarAlumno");
    }
    
    public static List<Alumno> buscarPorCurso(Curso curso){
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
