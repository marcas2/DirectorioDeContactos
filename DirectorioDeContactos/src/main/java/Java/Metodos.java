/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java;

import javax.servlet.ServletContext;

/**
 *  Metodos
 * @author Juan- María- Angel
 */

public class Metodos {
    
    /**
     * Metodo para mostrar el ID en el formulario
     * @param context
     * @return id
     */
    public static int mostrarId(ServletContext context){     
         Directorio arbol = Persistencia.deserializar(context);    
         if (arbol==null){//Prevenir errores
             arbol = new Directorio();  
         }
        int id=arbol.encontrarMaximoId()+1;//Se llama a metodo que encuentra el ID máximo y se le suma uno para establecer el nuevo ID
        
        return id;
    }
    /**
     * Metodo para mostrar la tabla
     * @param termino
     * @param context
     * @return tabla
     */
    public static String tabla (String termino, ServletContext context){
        Directorio directorio = Persistencia.deserializar(context);
                   
        if (directorio==null){//Prevenir errores
            directorio = new Directorio();  
        }
        
        String tabla=directorio.tabla();//Inicialmente se llena con la tabla de todos los contactos
        
        if(termino!=null){//Si hay un termino
            tabla=directorio.tablaBusqueda2(termino);//Se llena con la tabla de busqueda
            if (tabla==null){
            tabla=directorio.NoEncontrado();
            }
        }        
        return tabla; 
    }
}
