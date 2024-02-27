/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author maria
 */
public class Directorio implements Serializable{
    private Nodo raiz;

    public Directorio() {

    }

    public boolean existe(String busqueda) {
        return existe(this.raiz, busqueda);
    }

    private boolean existe(Nodo n, String busqueda) {
        if (n == null) {
            return false;
        }
        if (n.getContacto().getNombre().equals(busqueda)) {
            return true;
        } else if (busqueda.compareTo(n.getContacto().getNombre()) < 0) {
            return existe(n.getIzquierda(), busqueda);
        } else {
            return existe(n.getDerecha(), busqueda);
        }

    }

    public void insertar(Contacto dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        } else {
            this.insertar(this.raiz, dato);
        }
    }

    private void insertar(Nodo padre, Contacto dato) {
        if (dato.getNombre().compareTo(padre.getContacto().getNombre()) > 0) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new Nodo(dato));
            } else {
                this.insertar(padre.getDerecha(), dato);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new Nodo(dato));
            } else {
                this.insertar(padre.getIzquierda(), dato);
            }
        }
    }

    private void preorden(Nodo n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }

    private void inorden(Nodo n) {
        if (n != null) {
            inorden(n.getIzquierda());
            n.imprimirDato();
            inorden(n.getDerecha());
        }
    }

    private void postorden(Nodo n) {
        if (n != null) {
            postorden(n.getIzquierda());
            postorden(n.getDerecha());
            n.imprimirDato();
        }
    }
    public void preorden() {
        this.preorden(this.raiz);
    }

    public void inorden() {
        this.inorden(this.raiz);
    }

    public void postorden() {
        this.postorden(this.raiz);
    }
    public String tabla() {
    StringBuilder tablaHtml = new StringBuilder();
    construirTabla(this.raiz, tablaHtml);
    return tablaHtml.toString();
}

private void construirTabla(Nodo nodo, StringBuilder tablaHtml) {
    if (nodo != null) {
        tablaHtml.append("<tr>");
        tablaHtml.append("<td>").append(nodo.getContacto().getId()).append("</td>");
        tablaHtml.append("<td>").append(nodo.getContacto().getNombre()).append("</td>");
        tablaHtml.append("<td>").append(nodo.getContacto().getApellido()).append("</td>");
        tablaHtml.append("<td>").append(nodo.getContacto().getDireccion()).append("</td>");
        tablaHtml.append("<td>").append( nodo.getContacto().getCelular()).append("</td>");
        tablaHtml.append("<td>").append(nodo.getContacto().getCorreo()).append("</td>");
        tablaHtml.append("<td><center> <a href=\"#\" class=\"btn btn-info btn-circle\" data-bs-toggle=\"ver\" data-bs-target=\"#exampleModal\" data-nombre=\"").append(nodo.getContacto().getId()).append( "\" style=\"margin-left:5px; margin-right: 5px\"><i class=\"fa-regular fa-eye\"></i></a>");
        tablaHtml.append("<a href=\"#\" class=\"btn btn-warning btn-circle\" data-bs-toggle=\"editar\" data-bs-target=\"#editarModal\" data-nombre=\"" ).append(nodo.getContacto().getId()).append("\" style=\"margin-left:5px; margin-right: 5px\"><i class=\"fa-solid fa-user-pen\"></i></a>");
        tablaHtml.append("<a href=\"#\" class=\"btn btn-danger btn-circle deleteButton\" id=\"deleteButton\" data-titulo=\"" ).append(nodo.getContacto().getId()).append("\" style=\"margin-left:5px; margin-right: 5px\"><i class=\"fas fa-trash\"></i></a></center></td>");        tablaHtml.append("</tr>");
        construirTabla(nodo.getIzquierda(), tablaHtml);
        construirTabla(nodo.getDerecha(), tablaHtml);
    }
}
public Nodo encontrar(int id){
    return encontrarContacto(this.raiz,id);
}
private Nodo encontrarContacto(Nodo nodo, int id) {
    if (nodo != null) {
        if (nodo.getContacto().getId() == id) {
            return nodo; // Devolver el nodo cuando se encuentre
        } else {
            Nodo izquierda = encontrarContacto(nodo.getIzquierda(), id);
            if (izquierda != null) {
                return izquierda; // Si se encontró en la izquierda, devolver el nodo encontrado
            }
            return encontrarContacto(nodo.getDerecha(), id); // Recursión en el subárbol derecho
        }
    }
    return null; // Si no se encuentra, devolver null
}
public int encontrarMaximoId() {
    return encontrarMaximoIdRecursivo(raiz);
}

private int encontrarMaximoIdRecursivo(Nodo nodo) {
    if (nodo == null) {
        return 0; // Si el nodo es nulo, devolvemos el menor valor entero posible
    }
    
    int maxIdEnSubarbolIzquierdo = encontrarMaximoIdRecursivo(nodo.getIzquierda());
    int maxIdEnSubarbolDerecho = encontrarMaximoIdRecursivo(nodo.getDerecha());
    
    // Comparamos el ID máximo en el subárbol izquierdo, el derecho y el ID del nodo actual
    return Math.max(nodo.getContacto().getId(), Math.max(maxIdEnSubarbolIzquierdo, maxIdEnSubarbolDerecho));
}
public void editarContacto(int id, Contacto nuevoContacto) {
    // Buscar el nodo con el ID dado
    Nodo nodo = encontrarContacto(raiz, id);
    
    // Si el nodo no es nulo, actualiza los atributos del contacto
    if (nodo != null) {
        nodo.getContacto().setNombre(nuevoContacto.getNombre());
        nodo.getContacto().setApellido(nuevoContacto.getApellido());
        nodo.getContacto().setCorreo(nuevoContacto.getCorreo());
        nodo.getContacto().setDireccion(nuevoContacto.getDireccion());
        nodo.getContacto().setCelular(nuevoContacto.getCelular());
        // Puedes agregar más atributos según sea necesario
        
        System.out.println("Contacto editado correctamente.");
    } else {
        System.out.println("El contacto con el ID " + id + " no se encontró en el directorio.");
    }
}
public void eliminarContacto(int id) {
    if (raiz == null) {
        System.out.println("El directorio está vacío.");
        return;
    }
    
    raiz = eliminarNodo(raiz, id);
    System.out.println("Contacto eliminado correctamente.");
}

private Nodo eliminarNodo(Nodo nodo, int id) {
    if (nodo == null) {
        return null;
    }
    
    // Recursivamente buscar el nodo a eliminar
    if (id < nodo.getContacto().getId()) {
        nodo.setIzquierda(eliminarNodo(nodo.getIzquierda(), id));
    } else if (id > nodo.getContacto().getId()) {
        nodo.setDerecha(eliminarNodo(nodo.getDerecha(), id));
    } else {
        // Caso 1: El nodo a eliminar es una hoja o tiene un solo hijo
        if (nodo.getIzquierda() == null) {
            return nodo.getDerecha();
        } else if (nodo.getDerecha() == null) {
            return nodo.getIzquierda();
        }
        
        // Caso 2: El nodo a eliminar tiene dos hijos
        // Encontrar el sucesor en orden (el nodo más pequeño en el subárbol derecho)
        Nodo sucesor = encontrarSucesor(nodo.getDerecha());
        
        // Copiar los datos del sucesor al nodo actual
        nodo.getContacto().setId(sucesor.getContacto().getId());
        
        // Eliminar el sucesor
        nodo.setDerecha(eliminarNodo(nodo.getDerecha(), sucesor.getContacto().getId()));
    }
    
    return nodo;
}

private Nodo encontrarSucesor(Nodo nodo) {
    Nodo actual = nodo;
    while (actual.getIzquierda() != null) {
        actual = actual.getIzquierda();
    }
    return actual;
}
private void tablaBusqueda(Nodo nodo, StringBuilder tablaHtml, String termino) {
    boolean encontrado=false;
    if (nodo != null ) {
        if( nodo.getContacto().getNombre().contains(termino)){
        tablaHtml.append("<tr>");
        tablaHtml.append("<td>").append(nodo.getContacto().getId()).append("</td>");
        tablaHtml.append("<td>").append(nodo.getContacto().getNombre()).append("</td>");
        tablaHtml.append("<td>").append(nodo.getContacto().getApellido()).append("</td>");
        tablaHtml.append("<td>").append(nodo.getContacto().getDireccion()).append("</td>");
        tablaHtml.append("<td>").append( nodo.getContacto().getCelular()).append("</td>");
        tablaHtml.append("<td>").append(nodo.getContacto().getCorreo()).append("</td>");
        tablaHtml.append("<td><center> <a href=\"#\" class=\"btn btn-info btn-circle\" data-bs-toggle=\"ver\" data-bs-target=\"#exampleModal\" data-nombre=\"").append(nodo.getContacto().getId()).append( "\" style=\"margin-left:5px; margin-right: 5px\"><i class=\"fa-regular fa-eye\"></i></a>");
        tablaHtml.append("<a href=\"#\" class=\"btn btn-warning btn-circle\" data-bs-toggle=\"editar\" data-bs-target=\"#editarModal\" data-nombre=\"" ).append(nodo.getContacto().getId()).append("\" style=\"margin-left:5px; margin-right: 5px\"><i class=\"fa-solid fa-user-pen\"></i></a>");
        tablaHtml.append("<a href=\"#\" class=\"btn btn-danger btn-circle deleteButton\" id=\"deleteButton\" data-titulo=\"" ).append(nodo.getContacto().getId()).append("\" style=\"margin-left:5px; margin-right: 5px\"><i class=\"fas fa-trash\"></i></a></center></td>");        tablaHtml.append("</tr>");
        tablaBusqueda(nodo.getIzquierda(), tablaHtml, termino);
            tablaBusqueda(nodo.getDerecha(), tablaHtml,termino);
            encontrado=true;
        } else{
            tablaBusqueda(nodo.getIzquierda(), tablaHtml, termino);
            tablaBusqueda(nodo.getDerecha(), tablaHtml,termino);
        }

    }
}
    public String tablaBusqueda2(String termino) {
    StringBuilder tablaHtml = new StringBuilder();
    tablaBusqueda(this.raiz, tablaHtml, termino);
    return tablaHtml.toString();
}
    public String NoEncontrado() {
    StringBuilder tablaHtml = new StringBuilder();
    tablaHtml.append("<tr>");
            tablaHtml.append("<td>No encontrado</td>");
            tablaHtml.append("<td></td>");
            tablaHtml.append("<td></td>");
            tablaHtml.append("<td></td>");
            tablaHtml.append("<td></td>");
            tablaHtml.append("<td></td>");
            tablaHtml.append("<td></td>");
            tablaHtml.append("</tr>");
    return tablaHtml.toString();
}
}
