package aed;

public class Main {

    static Integer NCLAVES = 1000;

    public static void main(String[] args) {
        ABB<Integer> c = new ABB<Integer>();
        c.insertar(5);
        c.insertar(4);
        c.insertar(7);
        c.insertar(6);
        c.insertar(8);
        System.out.println(c.toString());
        c.eliminar(5);
        System.out.println(c.toString());
        c.eliminar(7);
        System.out.println("HI");
        System.out.println(c.toString());
    

    /* ABB<Integer> conjunto = new ABB<Integer>();

    // Insertar
    for (Integer i = 0; i < NCLAVES; i++) {
        Integer k = clave(i);
        System.out.println("Cardinal: " + conjunto.cardinal() + " Expected: " + i);
        System.out.println("Pertenece " + k + ": " + conjunto.pertenece(k) + " Expected: false");
        conjunto.insertar(k);
        System.out.println("Pertenece " + k + ": " + conjunto.pertenece(k) + " Expected: true");
    }


    }

    private static Integer clave(Integer i) {
        return NCLAVES * ((i * i - 100 * i) % NCLAVES) + i;*/
    } 
}
