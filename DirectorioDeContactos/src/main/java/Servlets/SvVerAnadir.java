/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Java.Contacto;
import Java.Directorio;
import Java.Nodo;
import Java.Persistencia;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SvVerAnadir
 * @author Juan- Maria - Angel
 */
@WebServlet(name = "SvVerAnadir", urlPatterns = {"/SvVerAnadir"})
public class SvVerAnadir extends HttpServlet {
    /**
     * Metodo para ver contacto
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
        int id =Integer.parseInt(request.getParameter("id"));//Obtener id 
        ServletContext context = getServletContext();
         Directorio arbol =Persistencia.deserializar(context);
         if (arbol==null){
             arbol = new Directorio();  
         }
        Nodo li = arbol.encontrar(id);//Se encuentra el nodo para llenar la info
        // Verificar si el objeto no es nulo
        if (li != null) {
            // Construir una cadena HTML con información del contacto
            String contactoHtml = "<h2>Nombre: " + li.getContacto().getNombre() + "</h2>"+
                     "<h3> Id:</h3><p> " +li.getContacto().getId()+ "</p>" +
                    "<h3> Apellido:</h3><p> " +li.getContacto().getApellido()+ "</p>"+
                    "<h3> Direccion:</h3><p> " +li.getContacto().getDireccion()+ "</p>"+
                    "<h3> Telefono:</h3><p> " +li.getContacto().getCelular()+ "</p>"+
                    "<h3> Correo:</h3><p> " +li.getContacto().getCorreo()+ "</p>"
                 ;
            // Establecer el tipo de contenido de la respuesta
            response.setContentType("text/html; charset=UTF-8");
            // Escribir la cadena HTML en el cuerpo de la respuesta
            response.getWriter().write(contactoHtml);

        } else {
            /// Manejar el caso en el que el objeto es nulo
            response.setContentType("text/plain");// Establecer el tipo de contenido como texto plano
            response.getWriter().write("Contacto no encontrado"); // Escribir un mensaje indicando que el contacto no está disponible
        }
    }
    /**
     * Agregar
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * Parametros
         */
        int id=Integer.parseInt(request.getParameter("id"));
        String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String correo= request.getParameter("correo");
        String direccion= request.getParameter("direccion");
        String celular=request.getParameter("celular");
        
         ServletContext context = getServletContext();
         Directorio arbol =Persistencia.deserializar(context);
         String alert= "anadido";//Bandera
         if (arbol==null){
             arbol = new Directorio();  
         }
         if(!arbol.nombreBuscar(nombre)){//Se verifica si hay nombres iguales
            Contacto c= new Contacto(nombre, apellido,correo,direccion,id,celular);     
            arbol.insertar(c);
            Persistencia.serializar(arbol, context);
            arbol.inorden();
         } else{
            alert="nomRepetido";//Alerta para informar el nombre repetido 
         }
        
         response.sendRedirect("index.jsp?alert="+alert);
        
    }

}
