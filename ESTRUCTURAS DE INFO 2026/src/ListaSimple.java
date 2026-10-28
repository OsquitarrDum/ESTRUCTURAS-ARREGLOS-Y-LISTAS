public class ListaSimple {Nodo cabeza;

    public ListaSimple() {
        this.cabeza = null;
    }

    // 1. InsertAtEnd (Insertar al Final)
    public void insertAtEnd(int valor) {
        Nodo nuevoNodo = new Nodo(valor);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            return;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = nuevoNodo;
    }
    // Método extra para poder ver la lista en la consola
    public void mostrar() {
        Nodo actual = cabeza;
        System.out.print("Nodos en la lista: ");
        while (actual != null) {
            System.out.print(actual.valor + " -> ");
            actual = actual.siguiente; // Salta al siguiente nodo
        }
        System.out.println("null"); // Indica el final de la cola
    }
}

