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
 *  SvEditar
 * @author Juan- Maria - Angel
 */
@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {
    /**
     * Mostrar en modal la informacion a editar
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        Directorio arbol = new Directorio();
        arbol = Persistencia.deserializar(context);

        if (arbol == null) {
            arbol = new Directorio();
        }
        //pedimos el id del contacto y lo guardamos en una variable
        int id = Integer.parseInt(request.getParameter("id"));

        Nodo li = arbol.encontrar(id);//Buscamos el nodo

        // Verificación si el objeto 'li' no es nulo
        if (li != null) {
            // Sección para el caso en que 'li' no sea nulo 
            // Construcción de una cadena que representa el formulario de edición del contacto
            String ContactoHtml = "<form action=\"SvGestiones\" method=\"POST\" >\n"
                    + "                            <div>\n"
                    + "                                <label class=\"form-label\">Id</label>\n"
                    + "                                <input type=\"text\" class=\"form-control\" name=\"id\" value=\"" + li.getContacto().getId() + "\" readonly>\n"
                    + "                            </div>\n"
                    + "                            <div>\n"
                    + "                                <label class=\"form-label\">Nombre</label>\n"
                    + "                                <input type=\"text\" class=\"form-control\" id=\"validationCustom02\" name=\"nombre\" value=\"" + li.getContacto().getNombre() + "\" readonly>\n"
                    + "                                </div>\n"
                    + "                                <div>\n"
                    + "                                  <label class=\"form-label\">Apellido</label>\n"
                    + "                                    <input type=\"text\" class=\"form-control\" id=\"validationCustomUsername\" aria-describedby=\"inputGroupPrepend\" name=\"apellido\" value=\"" + li.getContacto().getApellido() + "\" required>\n"
                    + "                                </div>\n"
                    + "                                <div>\n"
                    + "                                  <label class=\"form-label\">Correo</label>\n"
                    + "                                  <input type=\"text\" class=\"form-control\" id=\"validationCustom03\" name=\"correo\" value=\"" + li.getContacto().getCorreo() + "\" required>\n"
                    + "                                </div>\n"
                    + "                               <div>\n"
                    + "                                  <label class=\"form-label\">Direccion</label>\n"
                    + "                                  <input type=\"text\" class=\"form-control\" id=\"validationCustom03\" name=\"direccion\" value=\"" + li.getContacto().getDireccion() + "\" required>\n"
                    + "                                </div>\n"
                    + "                                <div>\n"
                    + "                                  <label class=\"form-label\">Celular</label>\n"
                    + "                                  <input type=\"number\" class=\"form-control\" id=\"validationCustom05\" name=\"celular\" value=\"" + li.getContacto().getCelular() + "\" required>\n"
                    + "                                </div>\n"
                    + "                                   \n"
                    + "                                <div class=\"col-md-12\" style=\"margin-top:15px;\">\n"
                    + "                                    <center><button class=\"btn btn-primary\" type=\"submit\">Editar</button> <button class=\"btn btn-secondary\" type=\"button\" data-bs-dismiss=\"modal\">Cerrar</button></center>\n"
                    + "                                </div>\n"
                    + "                              </form>";

            // Configuración de la respuesta
            response.setContentType("text/html; charset=UTF-8");
            // Envío de la cadena como respuesta al cliente
            response.getWriter().write(ContactoHtml);
        } else {
            // Sección para el caso en el que no se encuentra el contacto
            // Configuración de la respuesta
            response.setContentType("text/plain");
            response.setContentType("text/html; charset=UTF-8");
            // Envío de un mensaje indicando que el contacto no está disponible
            response.getWriter().write("No disponible :(");
        }
    }
    /**
     * Editar
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recibir variables a editar
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        String celular = request.getParameter("celular");
        
        ServletContext context = getServletContext();
        Directorio arbol = Persistencia.deserializar(context);

        if (arbol == null) {
            arbol = new Directorio();
        }

        Contacto c = new Contacto(nombre, apellido, correo, direccion, id, celular);//Se crea nuevo objeto
        arbol.editarContacto(id, c); //Se edita
        Persistencia.serializar(arbol, context); //Serializamos para guardar los cambios
        arbol.inorden(); //Recorrido en consola para pruebas

        response.sendRedirect("index.jsp?alert=" + "editado");
    }

}
