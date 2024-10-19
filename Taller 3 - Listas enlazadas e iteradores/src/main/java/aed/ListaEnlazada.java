package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    // Completar atributos privados
    private int longitud;
    private Nodo primero;
    private Nodo ultimo;

    private class Nodo {
        // Completar
        private T valor;
        private Nodo pxmo;
        private Nodo prev;
        Nodo(T valor){this.valor = valor;}

    }

    public ListaEnlazada() {
        this.longitud = 0;
        this.primero = new Nodo(null);
        this.ultimo = new Nodo(null);
        return;
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        
        if (this.longitud == 0){
            this.primero = nuevo;
            this.ultimo = nuevo;

        } else {
            nuevo.pxmo = this.primero;
            this.primero.prev = nuevo;
            this.primero = nuevo;
        }
        
        this.longitud++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);

        if (this.longitud == 0){
            this.primero = nuevo;
            this.ultimo = nuevo;

        } else {
            nuevo.prev = this.ultimo;
            this.ultimo.pxmo = nuevo;
            this.ultimo = nuevo;
        }

        this.longitud++;
    }

    public T obtener(int i) {

        Nodo apuntado = this.primero;
        for (int j = 0; j < i; j++){
            apuntado = apuntado.pxmo;
        }
        
        return apuntado.valor;
    }

    public void eliminar(int i) {
        if(i<0 || this.longitud<i){return;}
        Nodo apuntado = this.primero;
        for (int j = 0; j < i; j++){
            apuntado = apuntado.pxmo;
        }
        
        //si es sólo uno
        if (this.longitud == 1){
            this.primero = null;
            this.ultimo = null;
            this.longitud = 0;
            return;
        }

        // uno el anterior con el siguiente para sacar el que quiero sacar
        // si no es el primero y no es el ultimo
        if (apuntado.prev != null && apuntado.pxmo != null){
            apuntado.prev.pxmo = apuntado.pxmo;
            apuntado.pxmo.prev = apuntado.prev; 
            } 
        else if (apuntado.prev == null && apuntado.pxmo != null){ //es el primero y tiene despues
                    this.primero = this.primero.pxmo;
                    this.primero.prev = null;
        } else if (apuntado.pxmo == null && apuntado.prev != null){ // es el ultimo y tiene antes
            this.ultimo = this.ultimo.prev;
            this.ultimo.pxmo = null;
        }

        this.longitud--;
    }

    public void modificarPosicion(int indice, T elem) {
        if(indice<0 || this.longitud<indice){return;}
        Nodo apuntado = this.primero;
        for (int j = 0; j < indice; j++){
            apuntado = apuntado.pxmo;
        }
        apuntado.valor = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        this.longitud = 0;
        this.primero = null;
        this.ultimo = null;

        /* this.longitud = lista.longitud;
        this.primero = lista.primero;
        this.ultimo = lista.ultimo; */
    
        Nodo lista_apuntado = lista.primero;

        for (int i=0; i<lista.longitud; i++){
            this.agregarAtras(lista_apuntado.valor);
            lista_apuntado = lista_apuntado.pxmo;
        }
    }
    
    @Override
    public String toString() {
        Nodo apuntado = this.primero;
        String res = "[";
        if (this.longitud !=0){
            res = res + apuntado.valor.toString() + ", ";
        }
        while(apuntado.pxmo != null){
            //res = res + "nada";
            apuntado = apuntado.pxmo;
            res = res + apuntado.valor.toString() + ", ";
        }
        if (res != "["){res = res.substring(0, res.length()-2);}

        return res + "]";
    }

    private class ListaIterador implements Iterador<T> {

    	// Completar atributos privados
        ListaEnlazada<T> lista;
        int indice; 

        public boolean haySiguiente() {
	        return indice != lista.longitud;
        }
        
        public boolean hayAnterior() {
	        return indice != 0;
        }

        public T siguiente() {
            if (!haySiguiente()) {
                return null;
            }
            indice++;
            return lista.obtener(indice - 1);
        }
        

        public T anterior() {
            if (!hayAnterior()) {
                return null;
            }
	        indice = indice - 1;
            return lista.obtener(indice);
        }
    }

    public Iterador<T> iterador() {

        ListaIterador iterador = new ListaIterador();  
        iterador.lista = this;  
        iterador.indice = 0;
        return iterador;
    }

}
