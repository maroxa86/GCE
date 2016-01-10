package org.maroxa.gce.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.maroxa.gce.Constantes;
import org.maroxa.gce.HibernateHelper;

@Entity
@Table(name="Curso")
public class Curso {
    private static final Logger LOGGER = Logger.getLogger(Curso.class);
    
    @Id
    private int id;
    private String nombre;
    
    @OneToMany
    @JoinTable(name="curso")
    private List<Alumno> listaDeAlumnos;
    
    public Curso() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Curso(int id){
        super();
        this.id = id;
    }

    public Curso(int id, String nombre, List<Alumno> listaDeAlumnos) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.listaDeAlumnos = listaDeAlumnos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List<Alumno> getListaDeAlumnos() {
        return listaDeAlumnos;
    }

    public void setListaDeAlumnos(List<Alumno> listaDeAlumnos) {
        this.listaDeAlumnos = listaDeAlumnos;
    }

    public static List<Curso> buscarTodosLosCursos(){
        LOGGER.info(Constantes.INICIO_LOG + " buscarTodosLosCursos");
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        String consultaSQL = "from Curso curso";
        LOGGER.debug(Constantes.CONSULTA_SQL + consultaSQL);
        List<Curso> listaDeCursos = (List<Curso>)session.createQuery(consultaSQL).list();
        session.close();
        LOGGER.info(Constantes.FIN_LOG + " buscarTodosLosCursos");
        return listaDeCursos;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Curso other = (Curso) obj;
        if (id != other.id)
            return false;
        return true;
    }
  
}
