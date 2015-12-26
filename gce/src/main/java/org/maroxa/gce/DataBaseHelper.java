package org.maroxa.gce;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.maroxa.gce.exception.DataBaseException;

public class DataBaseHelper<T> {
    private static final Logger LOGGER = Logger.getLogger(DataBaseHelper.class);
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/gce";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";

    public List<T> seleccionarRegistros(String consultaSQL, Class clase){
        LOGGER.info(Constantes.INICIO_LOG + " seleccionarRegistros");
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet filas = null;
        List<T> listaDeObjetos = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            sentencia = conexion.createStatement();
            filas = sentencia.executeQuery(consultaSQL);
            while (filas.next()) {
                T objeto = (T) Class.forName(clase.getName()).newInstance();
                Method[] metodos = objeto.getClass().getDeclaredMethods();
                for (int i = 0; i < metodos.length; i++) {
                    if (metodos[i].getName().startsWith("set")) {
                        metodos[i].invoke(objeto, filas.getString(metodos[i].getName().substring(3)));
                    }
                    if (objeto.getClass().getName().equals("java.lang.String")) {
                        objeto = (T) filas.getString(1);
                    }
                }
                listaDeObjetos.add(objeto);
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error("No se encuentra la clase.");
            LOGGER.error(e.getMessage());
            throw new DataBaseException(e.getMessage(),e);
        } catch (SQLException e) {
            LOGGER.error("Error SQL.");
            LOGGER.error(e.getMessage());
            throw new DataBaseException(e.getMessage(),e);
        } catch (InstantiationException e) {
            LOGGER.error("Error Instanciación.");
            LOGGER.error(e.getMessage());
            throw new DataBaseException(e.getMessage(),e);
        } catch (IllegalAccessException e) {
            LOGGER.error("Error de acceso ilegal.");
            LOGGER.error(e.getMessage());
            throw new DataBaseException(e.getMessage(),e);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Error de argumento ilegal.");
            LOGGER.error(e.getMessage());
            throw new DataBaseException(e.getMessage(),e);
        } catch (InvocationTargetException e) {
            LOGGER.error("Error de invocación ilegal.");
            LOGGER.error(e.getMessage());
            throw new DataBaseException(e.getMessage(),e);
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    LOGGER.error("Error al cerrar el Statement.");
                    LOGGER.error(e.getMessage());
                    throw new DataBaseException(e.getMessage(),e);
                }
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                LOGGER.error("Error al cerrar la conexión.");
                LOGGER.error(e.getMessage());
                throw new DataBaseException(e.getMessage(),e);
            }
        }
        
        LOGGER.info(Constantes.FIN_LOG + " seleccionarRegistros");
        
        return listaDeObjetos;
    }

    public int modificarRegistro(String consultaSQL){
        LOGGER.info(Constantes.INICIO_LOG + " modificarRegistro");
        Connection conexion = null;
        Statement sentencia = null;
        int filasAfectadas = 0;
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            sentencia = conexion.createStatement();
            filasAfectadas = sentencia.executeUpdate(consultaSQL);
        } catch (ClassNotFoundException e) {
            LOGGER.error("No se encuentra la clase.");
            LOGGER.error(e.getMessage());
            throw new DataBaseException(e.getMessage(),e);
        } catch (SQLException e) {
            LOGGER.error("Error SQL.");
            LOGGER.error(e.getMessage());
            throw new DataBaseException(e.getMessage(),e);
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    LOGGER.error("Error al cerrar el Statement.");
                    LOGGER.error(e.getMessage());
                    throw new DataBaseException(e.getMessage(),e);
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    LOGGER.error("Error al cerrar la conexión.");
                    LOGGER.error(e.getMessage());
                    throw new DataBaseException(e.getMessage(),e);
                }
            }
        }
        LOGGER.info(Constantes.FIN_LOG + " modificarRegistro");
        
        return filasAfectadas;
    }
}