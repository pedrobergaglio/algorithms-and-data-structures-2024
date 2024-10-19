package aed;

public class Main {

    public static void main(String[] args) {
        // Create a new ListaEnlazada of integers
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        // Test agregarAdelante (add to the front)
        lista.agregarAdelante(3);
        lista.agregarAdelante(2);
        lista.agregarAdelante(1);

        System.out.println("After adding 1, 2, 3 at the front:");
        System.out.println(lista.toString());  // Expected: [1, 2, 3]

        // Test agregarAtras (add to the back)
        lista.agregarAtras(4);
        lista.agregarAtras(5);

        System.out.println("After adding 4, 5 at the back:");
        System.out.println(lista.toString());  // Expected: [1, 2, 3, 4, 5]

        // Test obtener (get value at index)
        System.out.println("Get element at index 2: " + lista.obtener(2)); // Expected: 3

        // Test eliminar (remove element)
        lista.eliminar(2);  // Remove the element at index 2 (which is 3)
        System.out.println("After removing element at index 2:");
        System.out.println(lista.toString());  // Expected: [1, 2, 4, 5]

        // Test eliminar first element
        lista.eliminar(0);  // Remove the first element (which is 1)
        System.out.println("After removing first element:");
        System.out.println(lista.toString());  // Expected: [2, 4, 5]

        // Test eliminar last element
        lista.eliminar(lista.longitud() - 1);  // Remove the last element (which is 5)
        System.out.println("After removing last element:");
        System.out.println(lista.toString());  // Expected: [2, 4]

        // Check the final size of the list
        System.out.println("Final size of the list: " + lista.longitud());  // Expected: 2
    }
}
