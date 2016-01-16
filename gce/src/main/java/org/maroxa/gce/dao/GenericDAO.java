package org.maroxa.gce.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, Id extends Serializable> {
    public T buscarPorClave(Id id);
    public List<T> buscarTodos();
    public void insertar(T objeto);
    public void salvar(T objeto);
    public void borrar(T objeto);
    
}
