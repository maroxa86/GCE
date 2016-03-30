package org.maroxa.gce.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.maroxa.gce.bean.Alumno;
import org.maroxa.gce.bean.Curso;
import org.maroxa.gce.bo.AlumnoBO;
import org.maroxa.gce.utils.GceUtils;

/**
 * Managed Bean que hace de nexeo entre la capa de presentación y la de negoció e inicia los procesos que solicita el 
 * usuario desde la capa de presentación
 * @author Xavi
 *
 */
//Ambito del ManagedBean
//Registra una clase como un ManagedBean y se le proporciona un nombre
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
    
    //Injecta una propiedad del ManagedBean 
    @ManagedProperty("#{alumnoBO}")
    private AlumnoBO alumnoBO;
    
    /**
     * Contructor generico de la clase
     */
    public AlumnoManagedBean(){
        super();
    }
    
 
    /**
     * Recupera los datos necesaios para mostrar por pantalla una vez el managed bean ha sido instanciado 
     */
    @PostConstruct
    public void init(){
        listaDeAlumnos = getAlumnoBO().buscarTodosLosAlumno();
        List<Curso> cursos = getAlumnoBO().buscarCursos();
        listaDeCursos = new ArrayList<>();
        for (Curso infoCurso : cursos) {
            listaDeCursos.add(new SelectItem(infoCurso.getId(), infoCurso.getNombre()));
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
        return GceUtils.cloneListaAlumnos(listaDeAlumnos);
    }

    public void setListaDeAlumnos(List<Alumno> listaDeAlumnos) {
        this.listaDeAlumnos = GceUtils.cloneListaAlumnos(listaDeAlumnos);
    }

    public List<SelectItem> getListaDeCursos() {
        return GceUtils.cloneListaSelectItemCurso(listaDeCursos);
    }

    public void setListaDeCursos(List<SelectItem> listaDeCursos) {
        this.listaDeCursos = GceUtils.cloneListaSelectItemCurso(listaDeCursos);
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public AlumnoBO getAlumnoBO() {
        return alumnoBO;
    }

    public void setAlumnoBO(AlumnoBO alumnoBO) {
        this.alumnoBO = alumnoBO;
    }

    /**
     * Encargado de realizar la acción de insertar un nuevo alumno 
     */
    public void insertar() {
        getAlumnoBO().insertarAlumno(new Alumno(Integer.parseInt(getId()), getNombre(), getPrimerApellido(),
                getSegundoApellido(), new Curso(getCurso())));
        setListaDeAlumnos(getAlumnoBO().buscarTodosLosAlumno());
        setCurso(0);
    }

    /**
     * Encargado de realizar la acción de eliminar un alumno
     * @param id Identificador del alumno a eliminar
     */
    public void borrar(String id) {
        getAlumnoBO().borrarAlumno(new Alumno(Integer.parseInt(id)));
        setListaDeAlumnos(getAlumnoBO().buscarTodosLosAlumno());
    }

    /**
     * Encargado de filtrar los alumnos de la aplicación
     * @param evento Evento que realiza la llamada
     */
    public void filtrar(ValueChangeEvent evento) {
        int idCurso = Integer.parseInt(evento.getComponent().getAttributes().get("value").toString());
        if (idCurso != 0) {
            setListaDeAlumnos(getAlumnoBO().buscarAumnosPorCurso(new Curso(idCurso)));
        } else {
            setListaDeAlumnos(getAlumnoBO().buscarTodosLosAlumno());
        }
    }

    /**
     * Encargado de recuperar la información de un alumno para mostrarlos en el formulario de edición
     * @param id Identificador del alumno
     */ 
    public void editar(String id) {
        Alumno alumno = getAlumnoBO().buscarAlumnoPorClave(Integer.parseInt(id));
        this.id = alumno.getId().toString();
        nombre = alumno.getNombre();
        primerApellido = alumno.getPrimerApellido();
        segundoApellido = alumno.getSegundoApellido();
        curso = alumno.getCurso().getId();
        getAlumnoBO().borrarAlumno(new Alumno(Integer.parseInt(id)));
        setListaDeAlumnos(getAlumnoBO().buscarTodosLosAlumno());
    }

    /**
     * Encargado de realizar la acción de preparar el formulario para insertar un nuevo alumno
     */
    public void altaAlumno() {
        id = "";
        nombre = "";
        primerApellido = "";
        segundoApellido = "";
        List<Curso> cursos = getAlumnoBO().buscarCursos();
        listaDeCursos = new ArrayList<>();
        for (Curso infoCurso : cursos) {
            listaDeCursos.add(new SelectItem(infoCurso.getId(), infoCurso.getNombre()));
        }
    }

    /**
     * Encargado de guardar la información del alumno modificada.
     */
    public void salvar() {
        getAlumnoBO().salvarAlumno(
                new Alumno(Integer.parseInt(getId()), nombre, primerApellido, segundoApellido, new Curso(curso)));
        setListaDeAlumnos(getAlumnoBO().buscarTodosLosAlumno());
        curso = 0;
    }
}
