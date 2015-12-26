package org.maroxa.gce;

import java.util.List;

import org.apache.log4j.Logger;

public class Alumno {
    private static final Logger LOGGER = Logger.getLogger(DataBaseHelper.class);
    
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
        String consultaSQL = "select distinct(curso) from Alumno";
        LOGGER.debug(Constantes.CONSULTA_SQL + consultaSQL);
        DataBaseHelper<String> helper = new DataBaseHelper<>();
        LOGGER.info(Constantes.FIN_LOG + " buscarTodosLosCursos");
        return helper.seleccionarRegistros(consultaSQL, String.class);
    }

    public void insertar(){
        LOGGER.info(Constantes.INICIO_LOG + " insertar");
        String consultaSQL = "insert into Alumno (id, nombre, primerApellido, segundoApellido, curso) values ";
        consultaSQL += "('" + this.id + "','" + this.nombre + "','" + this.primerApellido + "', '" + this.segundoApellido 
                + "', " + this.curso + ")";
        LOGGER.debug(Constantes.CONSULTA_SQL + consultaSQL);
        DataBaseHelper<Alumno> helper = new DataBaseHelper<>();
        helper.modificarRegistro(consultaSQL);
        LOGGER.info(Constantes.FIN_LOG + " insertar");
    }

    public static List<Alumno> buscarTodos(){
        LOGGER.info(Constantes.INICIO_LOG + " buscarTodos");
        String consultaSQL = "select id, nombre, primerapellido, segundoapellido, curso from Alumno";
        LOGGER.debug(Constantes.CONSULTA_SQL + consultaSQL);
        DataBaseHelper<Alumno> helper = new DataBaseHelper<>();
        LOGGER.info(Constantes.FIN_LOG + " buscarTodos");
        return helper.seleccionarRegistros(consultaSQL, Alumno.class);
    }
    
    public void borrar(){
        LOGGER.info(Constantes.INICIO_LOG + " borrar");
        String consultaSQL = "delete from Alumno where id = " + this.id;
        LOGGER.debug(Constantes.CONSULTA_SQL + consultaSQL);
        DataBaseHelper<Alumno> helper = new DataBaseHelper<>();
        helper.modificarRegistro(consultaSQL);
        LOGGER.info(Constantes.FIN_LOG + " borrar");
    }
    
    public static Alumno buscarAlumnoPorClave(String id){
        LOGGER.info(Constantes.INICIO_LOG + " buscarAlumnoPorClave");
        String consultaSQL = "select id, nombre, primerApellido, segundoApellido, curso from Alumno where id = " + id;
        LOGGER.debug(Constantes.CONSULTA_SQL + consultaSQL);
        DataBaseHelper<Alumno> db = new DataBaseHelper<>();
        List<Alumno> listaAlumnos = db.seleccionarRegistros(consultaSQL, Alumno.class);
        LOGGER.info(Constantes.FIN_LOG + " buscarAlumnoPorClave");
        return listaAlumnos.get(0);
    }
    
    public void salvarAlumno(){
        LOGGER.info(Constantes.INICIO_LOG + " salvarAlumno");
        String consultaSQL = "update Alumno set id = " + this.id + ", nombre = '" + this.nombre + "', "
                + "primerApellido = '" + this.primerApellido + "', segundoApellido = '" + this.segundoApellido + "', "
                + "curso = " + this.curso + " where id = " + this.id;
        LOGGER.debug(Constantes.CONSULTA_SQL + consultaSQL);
        DataBaseHelper<Alumno> db = new DataBaseHelper<>();
        db.modificarRegistro(consultaSQL);
        LOGGER.info(Constantes.FIN_LOG + " salvarAlumno");
    }
    
    public static List<Alumno> buscarPorCurso(String curso){
        LOGGER.info(Constantes.INICIO_LOG + " buscarPorCurso");
        String consultaSQL = "select id, nombre, primerApellido, segundoApellido, curso from Alumno "
                + "where curso = " + curso;
        LOGGER.debug(Constantes.CONSULTA_SQL + consultaSQL);
        DataBaseHelper<Alumno> db = new DataBaseHelper<>();
        LOGGER.info(Constantes.FIN_LOG + " buscarPorCurso");
        return db.seleccionarRegistros(consultaSQL, Alumno.class);
    }
}
