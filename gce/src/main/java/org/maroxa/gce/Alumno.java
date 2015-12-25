package org.maroxa.gce;

import java.util.List;

public class Alumno {
    
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
        String consultaSQL = "select distinct(curso) from Alumno";
        DataBaseHelper<String> helper = new DataBaseHelper<>();
        return helper.seleccionarRegistros(consultaSQL, String.class);
    }

    public void insertar(){
        String consultaSQL = "insert into Alumno (id, nombre, primerApellido, segundoApellido, curso) values ";
        consultaSQL += "('" + this.id + "','" + this.nombre + "','" + this.primerApellido + "', '" + this.segundoApellido 
                + "', " + this.curso + ")";
        DataBaseHelper<Alumno> helper = new DataBaseHelper<>();
        helper.modificarRegistro(consultaSQL);
    }

    public static List<Alumno> buscarTodos(){
        String consultaSQL = "select id, nombre, primerapellido, segundoapellido, curso from Alumno";
        DataBaseHelper<Alumno> helper = new DataBaseHelper<>();
        return helper.seleccionarRegistros(consultaSQL, Alumno.class);
    }
    
    public void borrar(){
        String consultaSQL = "delete from Alumno where id = " + this.id;
        DataBaseHelper<Alumno> helper = new DataBaseHelper<>();
        helper.modificarRegistro(consultaSQL);
    }
    
    public static Alumno buscarAlumnoPorClave(String id){
        String consultaSQL = "select id, nombre, primerApellido, segundoApellido, curso from Alumno where id = " + id;
        DataBaseHelper<Alumno> db = new DataBaseHelper<>();
        List<Alumno> listaAlumnos = db.seleccionarRegistros(consultaSQL, Alumno.class);
        return listaAlumnos.get(0);
    }
    
    public void salvarAlumno(){
        String consultaSQL = "update Alumno set id = " + this.id + ", nombre = '" + this.nombre + "', "
                + "primerApellido = '" + this.primerApellido + "', segundoApellido = '" + this.segundoApellido + "', "
                + "curso = " + this.curso + " where id = " + this.id;
        DataBaseHelper<Alumno> db = new DataBaseHelper<>();
        db.modificarRegistro(consultaSQL);
    }
    
    public static List<Alumno> buscarPorCurso(String curso){
        String consultaSQL = "select id, nombre, primerApellido, segundoApellido, curso from Alumno "
                + "where curso = " + curso;
        DataBaseHelper<Alumno> db = new DataBaseHelper<>();
        return db.seleccionarRegistros(consultaSQL, Alumno.class);
    }
}
