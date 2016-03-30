package org.maroxa.gce.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interfaz generica que describe los metodos genericos para comunicarse con la base de datos
 * @author Xavi
 *
 * @param <T> Indica la clase de mapeo con la que se quiere interactuar
 * @param <E> Tipo de dato del identificador de la clase de mapeo
 */
public interface GenericDAO<T, E extends Serializable> {
    /**
     * Busca la información de un tipo de objecto mediante su identificador
     * @param id Identificador del objeto
     * @return Devuelve un objeto del tipo indicado 
     */
    T buscarPorClave(E id);
    
    /**
     * Busca todos los registros de un objeto
     * @return Listado del tipo de objeto indicado.
     */
    List<T> buscarTodos();
    
    /**
     * Inserta un nuevo objeto de tipo T en la base de datos
     * @param objeto Información del objeto a insertar
     */
    void insertar(T objeto);
    
    /**
     * Guarda la información de un objeto tipo T
     * @param objeto Información del objeto a guardar
     */
    void salvar(T objeto);
    
    /**
     * Eliminar el registro al objeto tipo T
     * @param objeto Información del objeto a eliminar.
     */
    void borrar(T objeto);
}
