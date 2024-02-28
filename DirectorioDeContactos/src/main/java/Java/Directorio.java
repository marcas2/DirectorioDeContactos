/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *  Directorio
 * @author Juan- María- Angel
 */
public class Directorio implements Serializable{
    /**
     * Atributo para empezar el arbol binario
     */
    private Nodo raiz;
    
    /**
     * Constructor
     */
    public Directorio() {

    }
    /**
     * Metodo publico para ver si existe, el mismo llama al metodo privado que realiza la logica
     * @param busqueda
     * @return existe
     */
    public boolean existe(String busqueda) {
        return existe(this.raiz, busqueda);
    }
    /**
     * Metodo privado con la logica
     * @param n
     * @param busqueda
     * @return 
     */
    private boolean existe(Nodo n, String busqueda) {
        if (n == null) { //Si no hay raiz
            return false;
        }
        if (n.getContacto().getNombre().equals(busqueda)) {//Verifica el nodo actual
            return true;//En caso de existir envia true
        } else if (busqueda.compareTo(n.getContacto().getNombre()) < 0) {//Compara para saber que lado ir
            return existe(n.getIzquierda(), busqueda);//Busca en la izquierda
        } else {
            return existe(n.getDerecha(), busqueda);//Busca en la derecha
        }
    }
    /**
     * Metodo publico para insertar
     * @param dato 
     */
    public void insertar(Contacto dato) {
        if (this.raiz == null) { //Si no hay raiz, lo establece como la misma
            this.raiz = new Nodo(dato);
        } else {
            this.insertar(this.raiz, dato); //Caso contario llama al metodo privado
        }
    }
    /**
     * Metodo privado para insertar
     * @param padre
     * @param dato 
     */
    private void insertar(Nodo padre, Contacto dato) {
        if (dato.getNombre().compareTo(padre.getContacto().getNombre()) > 0) {//Compara para insertar
            if (padre.getDerecha() == null) {
                padre.setDerecha(new Nodo(dato));//Establece en la derecha
            } else {
                this.insertar(padre.getDerecha(), dato);//Utiliza la recursividad
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new Nodo(dato));//Inserta a la izquierda si no hay nada
            } else {
                this.insertar(padre.getIzquierda(), dato);//Utiliza la recursividad
            }
        }
    }
    /**
     * Recorridos
     */
    
     /**
     * Preorden
     */
    public void preorden() {
        this.preorden(this.raiz);
    }
    
    private void preorden(Nodo n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }
     /**
     * Inorden
     */
    public void inorden() {
        this.inorden(this.raiz);
    }
    
    private void inorden(Nodo n) {
        if (n != null) {
            inorden(n.getIzquierda());
            n.imprimirDato();
            inorden(n.getDerecha());
        }
    }
     /**
     * Postorden
     */
    public void postorden() {
        this.postorden(this.raiz);
    }
    
    private void postorden(Nodo n) {
        if (n != null) {
            postorden(n.getIzquierda());
            postorden(n.getDerecha());
            n.imprimirDato();
        }
    }

    /**
     * Gestion tabla
     */
    public String tabla() {
    StringBuilder tablaHtml = new StringBuilder();
    construirTabla(this.raiz, tablaHtml);//Se llama a metodo para que recorra el arbol
    return tablaHtml.toString();
}
    /**
     * Metodo que recorre el arbol
     * @param nodo
     * @param tablaHtml 
     */
    private void construirTabla(Nodo nodo, StringBuilder tablaHtml) {
        if (nodo != null) {//Si el nodo no es nulo, se muestran todos los datos
            tablaHtml.append("<tr>");
            tablaHtml.append("<td>").append(nodo.getContacto().getId()).append("</td>");
            tablaHtml.append("<td>").append(nodo.getContacto().getNombre()).append("</td>");
            tablaHtml.append("<td>").append(nodo.getContacto().getApellido()).append("</td>");
            tablaHtml.append("<td>").append(nodo.getContacto().getDireccion()).append("</td>");
            tablaHtml.append("<td>").append( nodo.getContacto().getCelular()).append("</td>");
            tablaHtml.append("<td>").append(nodo.getContacto().getCorreo()).append("</td>");
            tablaHtml.append("<td><center> <a href=\"#\" class=\"btn btn-info btn-circle\" data-bs-toggle=\"ver\" data-bs-target=\"#exampleModal\" data-nombre=\"").append(nodo.getContacto().getId()).append( "\" style=\"margin-left:5px; margin-right: 5px\"><i class=\"fa-regular fa-eye\"></i></a>");
            tablaHtml.append("<a href=\"#\" class=\"btn btn-warning btn-circle\" data-bs-toggle=\"editar\" data-bs-target=\"#editarModal\" data-nombre=\"" ).append(nodo.getContacto().getId()).append("\" style=\"margin-left:5px; margin-right: 5px\"><i class=\"fa-solid fa-user-pen\"></i></a>");
            tablaHtml.append("<a href=\"#\" class=\"btn btn-danger btn-circle deleteButton\" id=\"deleteButton\" data-titulo=\"" ).append(nodo.getContacto().getNombre()).append("\" style=\"margin-left:5px; margin-right: 5px\"><i class=\"fas fa-trash\"></i></a></center></td>");        tablaHtml.append("</tr>");
            construirTabla(nodo.getIzquierda(), tablaHtml);//Recorremos toda la izquierda
            construirTabla(nodo.getDerecha(), tablaHtml); //Recorremos toda la derecha con recursividad
        }
    }
    /**
     * Encontrar Nodo por ID
     * @param id
     * @return NodoEncontrado
     */
    public Nodo encontrar(int id){
        return encontrarContacto(this.raiz,id);//Se llama al metodo privado
    }
    /**
     * Metodo privado para encontrar nodo
     * @param nodo
     * @param id
     * @return 
     */
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
    /**
     * Encontrar el ultimo ID
     * @return 
     */
    public int encontrarMaximoId() {
        return encontrarMaxId(raiz);//Se llama a metodo privado
    }
    /**
     * Metodo privado para encontrar el ID
     * @param nodo
     * @return 
     */
    private int encontrarMaxId(Nodo nodo) {
        if (nodo == null) {
            return 0; // Si el nodo es nulo, devolvemos el menor valor entero posible
        }
        int maxIzquierdo = encontrarMaxId(nodo.getIzquierda());
        int maxDerecho = encontrarMaxId(nodo.getDerecha());

        // Comparamos el ID máximo en el subárbol izquierdo, el derecho y el ID del nodo actual
        return Math.max(nodo.getContacto().getId(), Math.max(maxIzquierdo, maxDerecho));
    }
    /**
     * Editar contacto
     * @param id
     * @param nuevoContacto 
     */
    public void editarContacto(int id, Contacto nuevoContacto) {
        // Buscar el nodo con el ID dado
        Nodo nodo = encontrarContacto(raiz, id);

        // Si el nodo no es nulo, actualiza los atributos del contacto
        if (nodo != null) {
            nodo.getContacto().setApellido(nuevoContacto.getApellido());
            nodo.getContacto().setCorreo(nuevoContacto.getCorreo());
            nodo.getContacto().setDireccion(nuevoContacto.getDireccion());
            nodo.getContacto().setCelular(nuevoContacto.getCelular());

            System.out.println("Contacto editado correctamente.");
        } else {
            System.out.println("El contacto " + id + " no se encontró en el directorio.");
        }
    }
    /**
     * Encontrar nombre
     * @param termino
     * @return true/false
     */
    public Boolean nombreBuscar(String termino){
        return nomBus(raiz,termino);//Se llama a metodo privado
    }
    /**
     * Metodo privado para buscar el nombre
     * @param nodo
     * @param termino
     * @return true/false
     */
    private boolean nomBus(Nodo n,  String busqueda) { 
        if (n == null) { //Si no hay raiz
            return false;
        }
        if (n.getContacto().getNombre().equals(busqueda)) {//Verifica el nodo actual
            return true;//En caso de existir envia true
        } else if (busqueda.compareTo(n.getContacto().getNombre()) < 0) {//Compara para saber que lado ir
            return existe(n.getIzquierda(), busqueda);//Busca en la izquierda
        } else {
            return existe(n.getDerecha(), busqueda);//Busca en la derecha
        }   
    }
    
    /**
     * Tabla de busqueda
     * @param termino
     * @return 
     */
    public String tablaBusqueda2(String termino) {
        StringBuilder tablaHtml = new StringBuilder();
        tablaBusqueda(this.raiz, tablaHtml, termino);//Se llama al metodo privado
        return tablaHtml.toString();
    }
    
    /**
     * Tabla de busqueda
     * @param nodo
     * @param tablaHtml
     * @param termino 
     */
    private void tablaBusqueda(Nodo nodo, StringBuilder tablaHtml, String termino) {
        if (nodo != null ) {//Previene errores
            if( nodo.getContacto().getNombre().equalsIgnoreCase(termino)||nodo.getContacto().getApellido().equalsIgnoreCase(termino)||nodo.getContacto().getCelular().equalsIgnoreCase(termino)){//Compara en cada caso
            tablaHtml.append("<tr>");
            tablaHtml.append("<td>").append(nodo.getContacto().getId()).append("</td>");
            tablaHtml.append("<td>").append(nodo.getContacto().getNombre()).append("</td>");
            tablaHtml.append("<td>").append(nodo.getContacto().getApellido()).append("</td>");
            tablaHtml.append("<td>").append(nodo.getContacto().getDireccion()).append("</td>");
            tablaHtml.append("<td>").append( nodo.getContacto().getCelular()).append("</td>");
            tablaHtml.append("<td>").append(nodo.getContacto().getCorreo()).append("</td>");
            tablaHtml.append("<td><center> <a href=\"#\" class=\"btn btn-info btn-circle\" data-bs-toggle=\"ver\" data-bs-target=\"#exampleModal\" data-nombre=\"").append(nodo.getContacto().getId()).append( "\" style=\"margin-left:5px; margin-right: 5px\"><i class=\"fa-regular fa-eye\"></i></a>");
            tablaHtml.append("<a href=\"#\" class=\"btn btn-warning btn-circle\" data-bs-toggle=\"editar\" data-bs-target=\"#editarModal\" data-nombre=\"" ).append(nodo.getContacto().getId()).append("\" style=\"margin-left:5px; margin-right: 5px\"><i class=\"fa-solid fa-user-pen\"></i></a>");
            tablaHtml.append("<a href=\"#\" class=\"btn btn-danger btn-circle deleteButton\" id=\"deleteButton\" data-titulo=\"" ).append(nodo.getContacto().getNombre()).append("\" style=\"margin-left:5px; margin-right: 5px\"><i class=\"fas fa-trash\"></i></a></center></td>");        tablaHtml.append("</tr>");
            tablaBusqueda(nodo.getIzquierda(), tablaHtml, termino);//Se sigue buscando
            tablaBusqueda(nodo.getDerecha(), tablaHtml,termino);
            } else{//busca 
                tablaBusqueda(nodo.getIzquierda(), tablaHtml, termino);
                tablaBusqueda(nodo.getDerecha(), tablaHtml,termino);
            }

        }
    }
    /**
     * En caso de no encontrar nada
     * @return 
     */
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
    /**
     * Llama el metodo de eliminar
     * @param nom 
     */
    public void eliminar (String nom){
        raiz=raiz.eliminar(nom);
    }
}
