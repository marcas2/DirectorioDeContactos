/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java;

import java.io.Serializable;

/**
 *
 * @author maria
 */
public class Nodo implements Serializable {
    Contacto contacto;
    Nodo izquierda, derecha;

    public Nodo(Contacto contacto) {
        this.contacto = contacto;
        izquierda = derecha = null;
    }

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
    public void imprimirDato() { 
        System.out.println(this.getContacto().getNombre());
    }
    
private Nodo buscarSucesor() {
    return (izquierda == null) ? this : izquierda.buscarSucesor();
}

public Nodo eliminar(String unNombre) {
    if (contacto.getNombre().compareToIgnoreCase(unNombre) == 0) {
        if (izquierda == null) {
            return derecha;
        }
        if (derecha == null) {
            return izquierda;
        }
        Nodo sucesor = derecha.buscarSucesor();
        derecha = derecha.eliminar(sucesor.contacto.getNombre());
        sucesor.izquierda = izquierda;
        sucesor.derecha = derecha;
        return sucesor;
    } else if (contacto.getNombre().compareToIgnoreCase(unNombre) > 0 && izquierda != null) {
        izquierda = izquierda.eliminar(unNombre);
    } else if (derecha != null) {
        derecha = derecha.eliminar(unNombre);
    }
    return this;
}
}
