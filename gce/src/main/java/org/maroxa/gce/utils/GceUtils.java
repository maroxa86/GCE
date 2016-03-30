package org.maroxa.gce.utils;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.maroxa.gce.bean.Alumno;
import org.maroxa.gce.bean.Curso;

/**
 * Clase de utilidades para el proyecto
 * @author Xavi
 *
 */
public final class GceUtils {

    //Constructor privado
    private GceUtils(){
    }
    
    /**
     * Método estático capaz de clonar una lista de Alunos
     * @param listaOriginal Lista original de alumnos
     * @return Lista clonada de alumnos
     */
    public static List<Alumno> cloneListaAlumnos(List<Alumno> listaOriginal){
        List<Alumno> listaClonada = new ArrayList<>();
        for(Alumno alumnoOriginal : listaOriginal){
            listaClonada.add(Alumno.clone(alumnoOriginal));
        }
        return listaClonada;
    }
    
    /**
     * Método estático capaz de clonar una lista de cursos
     * @param listaOriginal Lista original de cursos
     * @return Lista clonada de cursos
     */
    public static List<Curso> cloneListaCursos(List<Curso> listaOriginal){
        List<Curso> listaClonada = new ArrayList<>();
        for(Curso cursoOriginal : listaOriginal){
            listaClonada.add(Curso.clone(cursoOriginal));
        }
        return listaClonada;
    }
    
    /**
     * Método estático capaz de clonar una lista de SelectItems
     * @param listaOriginal ListaOriginal de SelectItems
     * @return ListaClonada de SelectItems
     */
    public static List<SelectItem> cloneListaSelectItemCurso(List<SelectItem> listaOriginal){
        List<SelectItem> listaClonada = new ArrayList<>();
        for(SelectItem datoOriginal : listaOriginal){
            listaClonada.add(new SelectItem((Integer)datoOriginal.getValue(), datoOriginal.getLabel()));
        }
        return listaClonada;
    }
}
