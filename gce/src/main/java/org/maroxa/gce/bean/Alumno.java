package org.maroxa.gce.bean;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase responsable de mapear la tabla Alumno de la base de datos
 * @author Xavi
 *
 */
//Indica que esta clase es una Entidad de base de datos
@Entity
//Indica que es una tabla y a cual hace referencia en la base de datos
@Table(name="Alumno")
public class Alumno implements Serializable{
    private static final long serialVersionUID = 857824263274499938L;
    
    //Indica el identificador de la tabla
    @Id
    private Integer id; 
    private String nombre;
    private String primerApellido;
    private String segundoApellido; 
    
    //Indica que existe una relación muchos a uno
    @ManyToOne
    //Identificador de el campo que establece la relación
    @JoinColumn(name="curso")
    private Curso curso;

    /**
     * Constructor por defecto
     */
    public Alumno() {
        super();
    }

    /**
     * Constructor que se le proporciona el identificador
     * @param id Identificador de la tabla Alumno
     */
    public Alumno(Integer id) {
        super();
        this.id = id;
    }
    
    /**
     * Constructor a que se le proporcionan toda la información de un alumno
     * @param id Identificador del alumno
     * @param nombre Nombre del alumno
     * @param primerApellido Primer apellido del alumno
     * @param segundoApellido Segundo apellido del alumno
     * @param curso Objeto con la información del curso al que pertenece el alumno
     */
    public Alumno(Integer id, String nombre, String primerApellido, String segundoApellido, Curso curso) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.curso = curso;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
     * Clona la información del alumno en un nuevo objeto
     * @param alumnoOriginal Información del alumno a clonar
     * @return Objeto clonado
     */
    public static Alumno clone(Alumno alumnoOriginal) {
        return new Alumno(alumnoOriginal.getId(), alumnoOriginal.getNombre(),
                alumnoOriginal.getPrimerApellido(), alumnoOriginal.getSegundoApellido(), alumnoOriginal.getCurso());
    }
}
