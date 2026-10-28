public class Main {
    public static void main(String[] args) {
        System.out.println("--- PRUEBA ARREGLOS ---");
        int[] arregloCeros = {0, 1, 0, 3, 12};
        EjerciciosArreglos.moverCeros(arregloCeros);
        System.out.println("Arreglo sin ceros: " + java.util.Arrays.toString(arregloCeros));

        int[] arregloFaltante = {1, 2, 3, 5};
        System.out.println("Numero faltante: " + EjerciciosArreglos.encontrarFaltante(arregloFaltante, 5));

        System.out.println("\n--- PRUEBA LISTAS ENLAZADAS ---");
        ListaSimple miLista = new ListaSimple();
        miLista.insertAtEnd(10);
        miLista.insertAtEnd(20);
        System.out.println("Nodos insertados correctamente al final de la lista.");

        //  método para ver el resultado://
        //   miLista.mostrar();
    }
}
