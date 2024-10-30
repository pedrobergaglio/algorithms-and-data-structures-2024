package aed;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto

    private Nodo raiz;
    private int cardinal;

    private class Nodo {
        // Agregar atributos privados del Nodo
        private T valor;
        private Nodo izq;
        private Nodo der;
        private Nodo padre;
        // Crear Constructor del nodo

        public Nodo(T valor, Nodo padre) {
            this.valor = valor;
            this.izq = null;
            this.der = null;
            this.padre = padre;
        }
    }

    public ABB() {
        this.cardinal = 0;
        this.raiz = null;
    }

    public int cardinal() {
        return this.cardinal;
    }

    public T minimo(){
        Nodo apuntado = raiz;
        while (apuntado.izq != null) {
            apuntado = apuntado.izq;
        }
        return apuntado.valor;
    }

    public T maximo(){
        Nodo apuntado = raiz;
        while (apuntado.der != null) {
            apuntado = apuntado.der;
        }
        return apuntado.valor;
    }

    public void insertar(T elem){
        if (this.raiz == null){
            raiz = new Nodo(elem, null);
            this.cardinal++;
            return;}

        if (pertenece(elem)){return;}

        Nodo apuntado = this.raiz;
        while (true){
        if (0 < elem.compareTo(apuntado.valor)){
            // es mas grande y no hay otro mas grande
            if (apuntado.der == null){
                apuntado.der = new Nodo(elem, apuntado);
                this.cardinal++;
                return;
            }
            apuntado = apuntado.der;
        } else {
            // es mas chico y no hay otro mas chico
            if (apuntado.izq == null){
                apuntado.izq = new Nodo(elem, apuntado);
                this.cardinal++;
                return;
            }
            apuntado = apuntado.izq;
        }
    }
    }

    public boolean pertenece(T elem){

        if (this.raiz == null){return false;}

        Nodo nodo = this.raiz;
        return perteneceRec(elem, nodo);
    }

    private Nodo sucesor(Nodo nodo){
        
        // caso tiene subarbol derecho
        Nodo res;
        if (nodo.der != null){
            res = nodo.der;
            while (res.izq != null){
            res = res.izq;
            }
        } else {
            // caso contrario: no tiene subarbol derecho
            // el siguiente es el primer padre de un subarbol izquierdo
            res = nodo.padre;
            while (res.der != null && res.der.valor.equals(nodo.valor)) {
            res = res.padre;
            }
            }
        return res;
        }
     
    public void eliminar(T elem) {
        raiz = eliminarNodo(raiz, elem);
        if (!pertenece(elem)){
            this.cardinal--;
        }
    }
  
    public Nodo eliminarNodo(Nodo nodo, T elem) {
        if (nodo == null) {
            return nodo;
        }
    
        // Busca el nodo a eliminar
        if (elem.compareTo(nodo.valor) < 0) {  
            nodo.izq = eliminarNodo(nodo.izq, elem);
            if (nodo.izq != null) {
                nodo.izq.padre = nodo;
            }
        } else if (elem.compareTo(nodo.valor) > 0) {
            nodo.der = eliminarNodo(nodo.der, elem);
            if (nodo.der != null) {
                nodo.der.padre = nodo;
            }
        } else {
            // El nodo a eliminar ha sido encontrado
    
            // Caso de 0 o 1 hijo derecho
            if (nodo.izq == null) {
                Nodo aux = nodo.der;
                if (aux != null) aux.padre = nodo.padre; // Actualiza el padre del hijo derecho
                return aux;
            }
    
            // Caso de solo hijo izquierdo
            if (nodo.der == null) {
                Nodo aux = nodo.izq;
                if (aux != null) aux.padre = nodo.padre; // Actualiza el padre del hijo izquierdo
                return aux;
            }
    
            // Caso de 2 hijos: encuentra el sucesor
            Nodo sucesor = minimoNodo(nodo.der);
            nodo.valor = sucesor.valor;
            nodo.der = eliminarNodo(nodo.der, sucesor.valor);
    
            // Asegura que el padre del sucesor está actualizado
            if (nodo.der != null) {
                nodo.der.padre = nodo;
            }
        }
        return nodo;
    }
    
    public String toString(){
        Iterador<T> iterador = this.iterador();
        String res = "{";
        while (iterador.haySiguiente()){
            res += iterador.siguiente();
            if (iterador.haySiguiente()){
                res += ",";
            }
        }
        res += "}";
        return res;
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual = minimoNodo(raiz);

        public boolean haySiguiente() {            
            return this._actual != null;
        }
    
        public T siguiente() {
            T res = _actual.valor;
            if (_actual.der != null) {
                _actual = minimoNodo(_actual.der);
                return res;
            }
            _actual = siguientePadre(_actual);
            return res;

            
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

    //aux
    public Nodo minimoNodo(Nodo raiz){
        if (raiz == null) { 
            return null; 
        }
        if (raiz.izq == null) { 
            return raiz; 
        }
        return minimoNodo(raiz.izq);
    }

    public Nodo siguientePadre(Nodo nodo){
        Nodo res = nodo.padre;
        while (res != null && res.der == nodo){
            nodo = res;
            res = res.padre;
        }
        return res;
    }
    public Nodo nodo(T elem, Nodo raiz){

        if (this.raiz == null){return null;}

        Nodo apuntado = this.raiz;
        while (true){
            if (apuntado == null){return null;}
            if (apuntado.valor == elem){return apuntado;}
            if (0 < elem.compareTo(apuntado.valor)){
                // es mas grande
                apuntado = apuntado.der;
            } else {
                apuntado = apuntado.izq;
            } 
    }
    }
    private Boolean perteneceRec(T elem, Nodo nodo){
        if (nodo == null){
            return false;
        }else if (nodo.valor.equals(elem)){
            return true;
        }else if (nodo.valor.compareTo(elem)>0){//nodo>target
            return perteneceRec(elem, nodo.izq);
        }else{
            return perteneceRec(elem, nodo.der);
        }
    }

}
