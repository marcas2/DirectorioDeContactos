/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java;

import javax.servlet.ServletContext;

/**
 *
 * @author maria
 */
public class Metodos {
    public static int mostrarId(ServletContext context){
      
         Directorio arbol = new Directorio();  
         arbol = Persistencia.deserializar(context);
         if (arbol==null){
             arbol = new Directorio();  
         }
        int id=arbol.encontrarMaximoId()+1;
        return id;
    }
    public static String tabla (String termino, ServletContext context){
        Directorio directorio = new Directorio();  
        directorio = Persistencia.deserializar(context);
                   
        if (directorio==null){
            directorio = new Directorio();  
        }
        String tabla=directorio.tabla();
        if(termino!=null){
            tabla=directorio.tablaBusqueda2(termino);
            if (tabla==null){
            tabla=directorio.NoEncontrado();
            
        }
            }
        
        return tabla; 
}
}
