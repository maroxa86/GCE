package org.maroxa.gce.dao.impl;

import org.maroxa.gce.bean.Curso;
import org.maroxa.gce.dao.CursoDAO;
import org.springframework.stereotype.Repository;

/**
 * Implementación de los métodos de la interfaz CursoDAO y extiende la clase GerenicDAOImpl
 * @author Xavi
 *
 */
@Repository
public class CursoDAOImpl extends AbstractGenericDAOImpl<Curso, Integer> implements CursoDAO{
}
