public class Main {

    // 1. Buscar y Devolver Índice (Search)
    public static int buscar(int[] arreglo, int valor) {
        // Recorremos el arreglo elemento por elemento desde el índice 0 hasta el final
        for (int i = 0; i < arreglo.length; i++) {
            // Comprobamos si el elemento actual coincide con el valor buscado
            if (arreglo[i] == valor) {
                // Retornamos el índice inmediatamente y finalizamos la ejecución
                return i;
            }
        }
        // Si el ciclo concluye sin encontrar coincidencias, retornamos -1
        return -1;
    }

    // 2. Suma Total de Elementos
    public static int sumar(int[] arreglo) {
        // Inicializamos el acumulador en 0 antes de iniciar el recorrido
        int suma = 0;

        // Recorremos secuencialmente cada posición del arreglo
        for (int i = 0; i < arreglo.length; i++) {
            // Reasignamos suma agregándole el valor actual (suma = suma + arreglo[i])
            suma += arreglo[i];
        }

        // Devolvemos el acumulado final
        return suma;
    }

    // 3. Invertir Arreglo In Situ (Reverse)
    public static void invertir(int[] arreglo) {
        // Puntero 'inicio' apunta al primer elemento (índice 0)
        int inicio = 0;
        // Puntero 'fin' apunta al último elemento válido del arreglo
        int fin = arreglo.length - 1;

        // El ciclo se repite hasta que los punteros se crucen en el centro
        while (inicio < fin) {
            // Guardamos el valor de 'inicio' en una variable temporal para no perderlo
            int temp = arreglo[inicio];

            // Intercambio: asignamos el valor del puntero 'fin' en la posición de 'inicio'
            arreglo[inicio] = arreglo[fin];

            // Colocamos el valor guardado en 'temp' en la posición del puntero 'fin'
            arreglo[fin] = temp;

            // Desplazamos los punteros hacia el centro del arreglo
            inicio++; // Avanza hacia la derecha
            fin--;    // Retrocede hacia la izquierda
        }
    }

    // 4. Mover Ceros al Final
    public static void moverCeros(int[] arreglo) {
        // Puntero que rastrea el índice donde se colocará el próximo elemento diferente de 0
        int idxNoCero = 0;

        // Primer ciclo: desplaza todos los números no ceros al inicio del arreglo
        for (int i = 0; i < arreglo.length; i++) {
            // Si el elemento evaluado no es cero
            if (arreglo[i] != 0) {
                // Lo reasignamos a la posición que indica el puntero idxNoCero
                arreglo[idxNoCero] = arreglo[i];
                // Avanzamos el puntero idxNoCero a la siguiente posición disponible
                idxNoCero++;
            }
        }

        // Segundo ciclo: desde la posición final de idxNoCero hasta el final del arreglo,
        // rellenamos todas las posiciones restantes con 0
        for (int i = idxNoCero; i < arreglo.length; i++) {
            arreglo[i] = 0;
        }
    }
}