package org.maroxa.gce.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.maroxa.gce.Constantes;
import org.maroxa.gce.HibernateHelper;
@Entity
@Table(name="Alumno")
public class Alumno {
    private static final Logger LOGGER = Logger.getLogger(Alumno.class);
    
    @Id
    private String id; 
    private String nombre;
    private String primerApellido;
    private String segundoApellido; 
    private String curso;

    public Alumno() {
        super();
    }

    public Alumno(String id) {
        super();
        this.id = id;
    }
    
    public Alumno(String id, String nombre, String primerApellido, String segundoApellido, String curso) {
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public static List<String> buscarTodosLosCursos(){
        LOGGER.info(Constantes.INICIO_LOG + " buscarTodosLosCursos");
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        String consultaSQL = "select distinct(alumno.curso) from Alumno alumno";
        LOGGER.debug(Constantes.CONSULTA_SQL + consultaSQL);
        List<String> listaDeCursos = (List<String>)session.createQuery(consultaSQL).list();
        session.close();
        LOGGER.info(Constantes.FIN_LOG + " buscarTodosLosCursos");
        return listaDeCursos;
    }

    public void insertar(){
        LOGGER.info(Constantes.INICIO_LOG + " insertar");
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        session.beginTransaction();
        session.save(this);
        session.getTransaction().commit();
        session.close();
        LOGGER.info(Constantes.FIN_LOG + " insertar");
    }

    public static List<Alumno> buscarTodos(){
        LOGGER.info(Constantes.INICIO_LOG + " buscarTodos");
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        String consultaSQL = " from Alumno alumno";
        LOGGER.debug(Constantes.CONSULTA_SQL + consultaSQL);
        List<Alumno> listaDeAlumnos = (List<Alumno>)session.createQuery(consultaSQL).list();
        session.close();
        LOGGER.info(Constantes.FIN_LOG + " buscarTodos");
        return listaDeAlumnos;
    }
    
    public void borrar(){
        LOGGER.info(Constantes.INICIO_LOG + " borrar");
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        session.beginTransaction();
        session.delete(this);
        session.getTransaction().commit();
        session.close();
        LOGGER.info(Constantes.FIN_LOG + " borrar");
    }
    
    public static Alumno buscarAlumnoPorClave(String id){
        LOGGER.info(Constantes.INICIO_LOG + " buscarAlumnoPorClave");
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        Alumno alumno = (Alumno) session.get(Alumno.class, id);
        session.close();
        LOGGER.info(Constantes.FIN_LOG + " buscarAlumnoPorClave");
        return alumno;
    }
    
    public void salvarAlumno(){
        LOGGER.info(Constantes.INICIO_LOG + " salvarAlumno");
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        session.beginTransaction();
        session.saveOrUpdate(this);
        session.getTransaction().commit();
        session.close();
        LOGGER.info(Constantes.FIN_LOG + " salvarAlumno");
    }
    
    public static List<Alumno> buscarPorCurso(String curso){
        LOGGER.info(Constantes.INICIO_LOG + " buscarPorCurso");
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        Query consultaSQL = session.createQuery("from Alumno alumno where alumno.curso =:curso");
        consultaSQL.setString("curso", curso);
        LOGGER.debug(Constantes.CONSULTA_SQL + consultaSQL);
        List<Alumno> listaDeAlumnos = (List<Alumno>) consultaSQL.list();
        session.close();
        LOGGER.info(Constantes.FIN_LOG + " buscarPorCurso");
        return listaDeAlumnos;
    }
}
