// Ejercicio 2: Invertir una lista enlazada
// Voltear las flechas: A -> B -> null queda B -> A -> null
public class Ejercicio2_InvertirLista {

    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int d) { dato = d; }
    }

    static Nodo invertir(Nodo cabeza) {
        Nodo prev = null;
        Nodo actual = cabeza;
        Nodo sig = null;

        while (actual != null) {
            sig = actual.siguiente;    // guardo el siguiente para no perder el resto
            actual.siguiente = prev;   // volteo la flecha
            prev = actual;             // avanzo los punteros
            actual = sig;
        }
        return prev; // prev quedó en el último nodo original: la nueva cabeza
    }

    public static void main(String[] args) {
        Nodo lista = crear(1, 2, 3, 4, 5);
        System.out.print("Antes:   ");
        imprimir(lista);
        System.out.print("Después: ");
        imprimir(invertir(lista));

        System.out.print("Lista vacía: ");
        imprimir(invertir(null));
    }

    // Ayudas para armar e imprimir la lista
    static Nodo crear(int... valores) {
        Nodo cabeza = null, ultimo = null;
        for (int d : valores) {
            Nodo n = new Nodo(d);
            if (cabeza == null) cabeza = n; else ultimo.siguiente = n;
            ultimo = n;
        }
        return cabeza;
    }

    static void imprimir(Nodo n) {
        while (n != null) {
            System.out.print(n.dato + " -> ");
            n = n.siguiente;
        }
        System.out.println("null");
    }
}