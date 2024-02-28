/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java;

import java.io.Serializable;

/**
 * Clase Nodo
 * @author Juan- María- Angel
 */

public class Nodo implements Serializable {
    /**
     * Atributos
     */
    Contacto contacto;
    Nodo izquierda, derecha;
    
    /**
     * Constructor
     */
    public Nodo(Contacto contacto) {
        this.contacto = contacto;
        izquierda = derecha = null;
    }
    /**
     * Getter y setter
     */
    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }
    /**
     * Imprimir dato en consola
     */
    public void imprimirDato() { 
        System.out.println(this.getContacto().getNombre());
    }
    /**
     * Buscar sucesor para eliminar
     */
    private Nodo buscarSucesor() {
        return (izquierda == null) ? this : izquierda.buscarSucesor();//Busca el ultimo a la izquierda
    }
    /**
     * Metodo eliminar que es llamado desde directorio
     */
    public Nodo eliminar(String unNombre) {
        
        if (contacto.getNombre().compareToIgnoreCase(unNombre) == 0) {//Verificar si coincide el nombre
            if (izquierda == null) {
                //Si no hay izquierda establece la derecha
                return derecha;
            }
            if (derecha == null) {
                //Si no hay derecha establece la izquierda
                return izquierda;
            }
            //Encuentra el sucesor en la derecha
            Nodo sucesor = derecha.buscarSucesor();
            derecha = derecha.eliminar(sucesor.contacto.getNombre());//Se borra
            //Asigna
            sucesor.izquierda = izquierda;
            sucesor.derecha = derecha;
            return sucesor;
        } else if (contacto.getNombre().compareToIgnoreCase(unNombre) > 0 && izquierda != null) {//Compara y previene errores
            izquierda = izquierda.eliminar(unNombre);//Elimina
        } else if (derecha != null) { //Previene errores
            derecha = derecha.eliminar(unNombre);//Elimina
        }
        return this;//Regresa el nodo
    }
}
