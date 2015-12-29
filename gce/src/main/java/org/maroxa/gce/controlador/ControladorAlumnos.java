package org.maroxa.gce.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.Alumno;

/**
 * Servlet implementation class ControladorAlumnos
 */
public class ControladorAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorAlumnos() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    RequestDispatcher despachador = null;
    	if(request.getServletPath().equals("/mostrarAlumnos.do")){
    	    List<Alumno> listaDeAlumnos = Alumno.buscarTodos();
    	    List<String> listaDeCursos = Alumno.buscarTodosLosCursos();
    	    request.setAttribute("listaDeAlumnos", listaDeAlumnos);
    	    request.setAttribute("listaDeCursos", listaDeCursos);
    	    despachador = request.getRequestDispatcher("mostrarAlumnos.jsp");
	    }
    	else{
    	    if(request.getServletPath().equals("/altaAlumno.do")){
                List<String> listaDeCursos = Alumno.buscarTodosLosCursos();
                request.setAttribute("listaDeCursos", listaDeCursos);
                despachador = request.getRequestDispatcher("altaAlumno.jsp");
            } 
    	    else{
    	        if(request.getServletPath().equals("/insertarAlumno.do")){
    	            String id = request.getParameter("id");
    	            String nombre = request.getParameter("nombre");
    	            String primerApellido = request.getParameter("primerApellido");
    	            String segundoApellido = request.getParameter("segundoApellido");
    	            String curso = request.getParameter("curso");
    	            Alumno alumno = new Alumno(id, nombre, primerApellido, segundoApellido, curso);
    	            alumno.insertar();
    	            despachador = request.getRequestDispatcher("mostrarAlumnos.do");
    	        }
    	        else{
    	            if(request.getServletPath().equals("/borrarAlumno.do")){
    	                String id = request.getParameter("id");
    	                Alumno alumno = new Alumno(id);
    	                alumno.borrar();
                        despachador = request.getRequestDispatcher("mostrarAlumnos.do");
                    }
    	            else{
    	                if(request.getServletPath().equals("/editarAlumno.do")){
    	                    String id = request.getParameter("id");
    	                    List<String> listaDeCursos = Alumno.buscarTodosLosCursos();
    	                    request.setAttribute("listaDeCursos", listaDeCursos);
    	                    Alumno alumno = Alumno.buscarAlumnoPorClave(id);
    	                    request.setAttribute("alumno", alumno);
    	                    despachador = request.getRequestDispatcher("editarAlumno.jsp");
    	                }
    	                else{
    	                    if(request.getServletPath().equals("/salvarAlumno.do")){
    	                        String id = request.getParameter("id");
    	                        String nombre = request.getParameter("nombre");
    	                        String primerApellido = request.getParameter("primerApellido");
    	                        String segundoApellido = request.getParameter("segundoApellido");
    	                        String curso = request.getParameter("curso");
    	                        Alumno alumno = new Alumno(id, nombre, primerApellido, segundoApellido, curso);
    	                        alumno.salvarAlumno();
    	                        despachador = request.getRequestDispatcher("mostrarAlumnos.do");
    	                    }
    	                    else{
    	                        if(request.getServletPath().equals("/filtrarAlumnos.do")){
    	                            List<Alumno> listaDeAlumnos = null;
    	                            List<String> listaDeCursos = Alumno.buscarTodosLosCursos();
    	                            if (request.getParameter("curso") == null 
    	                                    || request.getParameter("curso").equals("seleccionar")) {
    	                                listaDeAlumnos = Alumno.buscarTodos();
    	                            } else {
    	                                listaDeAlumnos = Alumno.buscarPorCurso(request.getParameter("curso"));
    	                            }
    	                            request.setAttribute("listaDeAlumnos", listaDeAlumnos);
    	                            request.setAttribute("listaDeCursos", listaDeCursos);
    	                            despachador = request.getRequestDispatcher("mostrarAlumnos.jsp");
    	                        }
    	                    }
    	                }
    	            }
    	        }
    	    }
    	}
    	despachador.forward(request, response);
    }
}
