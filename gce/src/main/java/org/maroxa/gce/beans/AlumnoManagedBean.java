package org.maroxa.gce.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.bo.Curso;
import org.maroxa.gce.servicios.ServicioAlumno;

@ManagedBean(name="alumnoManagedBean")
@SessionScoped
public class AlumnoManagedBean {
    private String id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer curso;
    private List<Alumno> listaDeAlumnos;
    private List<SelectItem> listaDeCursos;
    
    @ManagedProperty("#{servicioAlumno}")
    private ServicioAlumno servicioAlumno;
    
    public AlumnoManagedBean(){
        super();
    }
    
    @PostConstruct
    public void init(){
        listaDeAlumnos = getServicioAlumno().buscarTodosLosAlumno();
        List<Curso> cursos = getServicioAlumno().buscarCursos();
        listaDeCursos = new ArrayList<SelectItem>();
        for (Curso curso : cursos) {
            listaDeCursos.add(new SelectItem(curso.getId(), curso.getNombre()));
        }
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

    public List<Alumno> getListaDeAlumnos() {
        return listaDeAlumnos;
    }

    public void setListaDeAlumnos(List<Alumno> listaDeAlumnos) {
        this.listaDeAlumnos = listaDeAlumnos;
    }

    public List<SelectItem> getListaDeCursos() {
        return listaDeCursos;
    }

    public void setListaDeCursos(List<SelectItem> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public ServicioAlumno getServicioAlumno() {
        return servicioAlumno;
    }

    public void setServicioAlumno(ServicioAlumno servicioAlumno) {
        this.servicioAlumno = servicioAlumno;
    }

    public void insertar() {
        getServicioAlumno().insertarAlumno(new Alumno(Integer.parseInt(getId()), getNombre(), getPrimerApellido(),
                getSegundoApellido(), new Curso(getCurso())));
        setListaDeAlumnos(getServicioAlumno().buscarTodosLosAlumno());
        setCurso(0);
    }

    public void borrar(String id) {
        getServicioAlumno().borrarAlumno(new Alumno(Integer.parseInt(id)));
        setListaDeAlumnos(getServicioAlumno().buscarTodosLosAlumno());
    }

    public void filtrar(ValueChangeEvent evento) {
        int idCurso = Integer.parseInt(evento.getComponent().getAttributes().get("value").toString());
        if (idCurso != 0) {
            setListaDeAlumnos(getServicioAlumno().buscarAumnosPorCurso(new Curso(idCurso)));
        } else {
            setListaDeAlumnos(getServicioAlumno().buscarTodosLosAlumno());
        }
    }

    public void editar(String id) {
        Alumno alumno = getServicioAlumno().buscarAlumnoPorClave(Integer.parseInt(id));
        this.id = alumno.getId().toString();
        nombre = alumno.getNombre();
        primerApellido = alumno.getPrimerApellido();
        segundoApellido = alumno.getSegundoApellido();
        curso = alumno.getCurso().getId();
        getServicioAlumno().borrarAlumno(new Alumno(Integer.parseInt(id)));
        setListaDeAlumnos(getServicioAlumno().buscarTodosLosAlumno());
    }

    public void altaAlumno(ActionEvent evento) {
        id = "";
        nombre = "";
        primerApellido = "";
        segundoApellido = "";
        List<Curso> cursos = getServicioAlumno().buscarCursos();
        listaDeCursos = new ArrayList<SelectItem>();
        for (Curso curso : cursos) {
            listaDeCursos.add(new SelectItem(curso.getId(), curso.getNombre()));
        }
    }

    public void salvar() {
        getServicioAlumno().salvarAlumno(new Alumno(Integer.parseInt(getId()), nombre, primerApellido, segundoApellido, new Curso(curso)));
        setListaDeAlumnos(getServicioAlumno().buscarTodosLosAlumno());
        curso = 0;
    }
}
