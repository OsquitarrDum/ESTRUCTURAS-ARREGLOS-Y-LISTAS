// Ejercicio 4: Eliminar duplicados de una lista ORDENADA
// 1 -> 1 -> 2 -> 3 -> 3 queda 1 -> 2 -> 3
// Al estar ordenada, los repetidos quedan pegados, así que comparo cada nodo con el siguiente
public class Ejercicio4_EliminarDuplicados {

    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int d) { dato = d; }
    }

    static void eliminarDuplicados(Nodo cabeza) {
        Nodo actual = cabeza;

        while (actual != null && actual.siguiente != null) {
            if (actual.dato == actual.siguiente.dato) {
                // Repetido: me lo salto (aquí NO avanzo, el nuevo siguiente también puede ser igual)
                actual.siguiente = actual.siguiente.siguiente;
            } else {
                actual = actual.siguiente; // distinto: sigo con el próximo
            }
        }
    }

    public static void main(String[] args) {
        Nodo lista = crear(1, 1, 2, 3, 3);
        System.out.print("Antes:   ");
        imprimir(lista);
        eliminarDuplicados(lista);
        System.out.print("Después: ");
        imprimir(lista);

        Nodo iguales = crear(5, 5, 5, 5);
        eliminarDuplicados(iguales);
        System.out.print("5,5,5,5 -> ");
        imprimir(iguales);
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
