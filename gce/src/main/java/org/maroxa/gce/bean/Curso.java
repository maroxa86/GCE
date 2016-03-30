package org.maroxa.gce.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.maroxa.gce.utils.GceUtils;

/**
 * Clase responsable de mapear la tabla Curso de la base de datos
 * @author Xavi
 *
 */
@Entity
@Table(name="Curso")
public class Curso implements Serializable{

    private static final long serialVersionUID = -5838502164438055598L;

    @Id
    private int id;
    private String nombre;
    
    //Indica que existe una relación uno a mucho
    @OneToMany
    @JoinTable(name="curso")
    private List<Alumno> listaDeAlumnos;
    
    /**
     * Constructor por defecto 
     */
    public Curso() {
        super();
    }
    
    /**
     * Constructor al cual se le proporciona el identificador del curso
     * @param id Identificador del curso
     */
    public Curso(int id){
        super();
        this.id = id;
    }

    /**
     * Constructor al cual se le proporcionan el identificador del curso y su nombre
     * @param id Identificador del curso
     * @param nombre Nombre del curso
     */
    public Curso(int id , String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    /**
     * Constructor al cual se le proporcionan todos los atributos del curso.
     * @param id Identificador del curos
     * @param nombre Nombre del curso 
     * @param listaDeAlumnos Lista de alumnos que realizan el curso
     */
    public Curso(int id, String nombre, List<Alumno> listaDeAlumnos) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.listaDeAlumnos = GceUtils.cloneListaAlumnos(listaDeAlumnos);
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
        return GceUtils.cloneListaAlumnos(listaDeAlumnos);
    }

    public void setListaDeAlumnos(List<Alumno> listaDeAlumnos) {
        this.listaDeAlumnos = GceUtils.cloneListaAlumnos(listaDeAlumnos);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this, obj);
    }

    /**
     * Clona la información del curso en un nuevo objeto
     * @param cursoOriginal Información del curso
     * @return Objeto clonado
     */
    public static Curso clone(Curso cursoOriginal) {
        return new Curso(cursoOriginal.getId(), cursoOriginal.getNombre());
    }
  
}
