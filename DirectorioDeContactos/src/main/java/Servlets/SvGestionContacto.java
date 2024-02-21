/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;



import Java.Contacto;
import Java.Directorio;
import Java.Persistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maria
 */
@WebServlet(name = "SvGestionContacto", urlPatterns = {"/SvGestionContacto"})
public class SvGestionContacto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id=Integer.parseInt(request.getParameter("id"));
        String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String correo= request.getParameter("correo");
        String direccion= request.getParameter("direccion");
        int celular=Integer.parseInt(request.getParameter("celular"));
         ServletContext context = getServletContext();
         Directorio arbol = new Directorio();  
         arbol = Persistencia.deserializar(context);
         System.out.println(arbol);
         if (arbol==null){
             arbol = new Directorio();  
         }
         //String a=Persistencia.deserializar(context);
            
         Contacto c= new Contacto(nombre, apellido,correo,direccion,id,celular);     
         arbol.insertar(c);
         Persistencia.serializar(arbol, context);
         arbol.inorden();
        response.sendRedirect("index.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
