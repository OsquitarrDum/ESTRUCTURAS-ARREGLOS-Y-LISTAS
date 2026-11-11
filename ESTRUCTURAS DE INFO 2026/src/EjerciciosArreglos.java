public class EjerciciosArreglos {
    // 4. Mover Ceros al Final
    public static void moverCeros(int[] arreglo) {
        int idxNoCero = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != 0) {
                arreglo[idxNoCero] = arreglo[i];
                idxNoCero++;
            }
        }
        for (int i = idxNoCero; i < arreglo.length; i++) {
            arreglo[i] = 0;
        }
    }

    // 5. Encontrar Número Faltante
    public static int encontrarFaltante(int[] arreglo, int N) {
        int sumaIdeal = N * (N + 1) / 2;
        int sumaReal = 0;
        for (int i = 0; i < arreglo.length; i++) {
            sumaReal += arreglo[i];
        }
        return sumaIdeal - sumaReal;
    }
}
