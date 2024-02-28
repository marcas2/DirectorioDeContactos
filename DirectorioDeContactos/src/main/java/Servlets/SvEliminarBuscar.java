/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Java.Directorio;
import Java.Persistencia;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Sv Eliminar Buscar
 * @author Juan- María- Angel
 */
@WebServlet(name = "SvEliminarBuscar", urlPatterns = {"/SvEliminarBuscar"})
public class SvEliminarBuscar extends HttpServlet {

    /**
     * Eliminar 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // int id = Integer.parseInt(request.getParameter("id"));
     String nombre= request.getParameter("id");
     ServletContext context = getServletContext();
     Directorio arbol = Persistencia.deserializar(context);
     System.out.println(arbol);
    if (arbol == null) {
        arbol = new Directorio();
    }
        arbol.eliminar(nombre); // Llama al método eliminarContacto con el nombre proporcionado
        Persistencia.serializar(arbol, context);
        response.sendRedirect("index.jsp?alert=eliminado");
    }
/**
 * Busqueda 
 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String termino=request.getParameter("termino");//Se llama al temrino de busqueda

        response.sendRedirect("index.jsp?termino="+termino); //Se redirige para cargar la lista con el metodo
    }

}
