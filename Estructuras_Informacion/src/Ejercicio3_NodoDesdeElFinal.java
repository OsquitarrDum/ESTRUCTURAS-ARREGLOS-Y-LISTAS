// Ejercicio 3: Devolver el nodo N contando desde el final, sin saber el tamaño
// Al rápido le doy N pasos de ventaja; cuando llega al final, el lento queda en el nodo que busco
public class Ejercicio3_NodoDesdeElFinal {

    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int d) { dato = d; }
    }

    static Nodo nodoDesdeElFinal(Nodo cabeza, int n) {
        if (n <= 0) return null;

        Nodo rapido = cabeza;
        Nodo lento = cabeza;

        // Adelanto el rápido N pasos (si me quedo sin nodos, la lista es muy corta)
        for (int i = 0; i < n; i++) {
            if (rapido == null) return null;
            rapido = rapido.siguiente;
        }

        // Muevo los dos de a un paso hasta que el rápido sea null
        while (rapido != null) {
            rapido = rapido.siguiente;
            lento = lento.siguiente;
        }
        return lento; // el lento es la respuesta
    }

    public static void main(String[] args) {
        Nodo lista = crear(10, 20, 30, 40, 50);
        imprimir(lista);

        for (int n : new int[]{1, 2, 5, 6}) {
            Nodo r = nodoDesdeElFinal(lista, n);
            System.out.println("N = " + n + " -> " + (r == null ? "no existe" : r.dato));
        }
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