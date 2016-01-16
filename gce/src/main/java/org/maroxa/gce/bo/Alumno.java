package org.maroxa.gce.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Alumno")
public class Alumno implements Serializable{
    private static final long serialVersionUID = 857824263274499938L;
    
    @Id
    private Integer id; 
    private String nombre;
    private String primerApellido;
    private String segundoApellido; 
    
    @ManyToOne
    @JoinColumn(name="curso")
    private Curso curso;

    public Alumno() {
        super();
    }

    public Alumno(Integer id) {
        super();
        this.id = id;
    }
    
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
        Alumno other = (Alumno) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
