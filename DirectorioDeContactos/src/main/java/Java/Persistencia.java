/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;

/**
 *
 * @author maria
 */
public class Persistencia {
    public static void serializar(Directorio arbol, ServletContext context) {

        String ruta = "/data/contactos.ser";//declaramos la ruta de nuestro archivo
        String rutaa = context.getRealPath(ruta);//asignamos la ruta
        File archivo = new File(rutaa);//creamos variable tipo file para asignar la ruta
        System.out.println(rutaa);
        //creamos un objeto tipo output para escribir la informacion
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo))) {
            //escribimos en el archivo
            salida.writeObject(arbol);
            System.out.println("Contactos serializada exitosamente en " + rutaa);
            //atrapamos errores de escritura
        } catch (IOException e) {
            System.out.println("NO SE SERIALIZO");
        }
        
    }

    /**
     * 
     * @param context
     * @return 
     */
    public static Directorio deserializar(ServletContext context) {
       
        Directorio biblioteca = null;//creamos objeto de tipo biblioteca
        String ruta = "/data/contactos.ser";//declaramos laruta del archivo a leer
        String rutaa = context.getRealPath(ruta);//asignamos la ruta
        File archivo = new File(rutaa);//creamos una variable tipo file y le asignamos nuestra ruta
        System.out.println(rutaa);
        
        //creamos un objeto tipo input para leer el archivo
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
            //leemos el archivo con el metodo readObject(
            biblioteca = (Directorio) entrada.readObject();
            System.out.println("Biblioteca deserializada exitosamente desde " + rutaa);
            
        //atrapamos posibles errores de lectura
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("NO SE DESERIALIZO");
        }
        System.out.println(biblioteca);
        //al ser un metodo de tipo biblioteca devolvemos un parametro de este tipo
        return biblioteca;
    }
}
