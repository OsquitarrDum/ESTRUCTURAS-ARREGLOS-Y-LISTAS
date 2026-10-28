// Ejercicio 5: Detectar un bucle (Liebre y Tortuga)
// Lento avanza 1 paso y rápido 2; si hay bucle, en algún momento se encuentran
public class Ejercicio5_DetectarBucle {

    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int d) { dato = d; }
    }

    static boolean tieneBucle(Nodo cabeza) {
        Nodo lento = cabeza;
        Nodo rapido = cabeza;

        // Reviso rapido y rapido.siguiente porque el rápido da 2 pasos
        while (rapido != null && rapido.siguiente != null) {
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;
            if (lento == rapido) return true; // se encontraron: hay bucle
        }
        return false; // el rápido llegó al final: no hay bucle
    }

    public static void main(String[] args) {
        Nodo normal = crear(1, 2, 3, 4, 5);
        System.out.println("Lista normal -> " + tieneBucle(normal));

        // Hago el bucle a mano: el nodo 5 vuelve a apuntar al nodo 3
        Nodo conBucle = crear(1, 2, 3, 4, 5);
        conBucle.siguiente.siguiente.siguiente.siguiente.siguiente = conBucle.siguiente.siguiente;
        System.out.println("Lista con bucle -> " + tieneBucle(conBucle));

        System.out.println("Lista vacía -> " + tieneBucle(null));
    }

    // Ayuda para armar la lista
    static Nodo crear(int... valores) {
        Nodo cabeza = null, ultimo = null;
        for (int d : valores) {
            Nodo n = new Nodo(d);
            if (cabeza == null) cabeza = n; else ultimo.siguiente = n;
            ultimo = n;
        }
        return cabeza;
    }
}