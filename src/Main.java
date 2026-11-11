public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("🚀 INICIANDO PRUEBAS - PILAS Y COLAS (GUARDIANES) 🚀");
        System.out.println("==================================================\n");

        // --- NIVEL 1: Desafío 1 (Rocket - Pila Limitada) ---
        System.out.println("--- NIVEL 1: Desafío 1 (Pila Limitada) ---");
        PilaLimitada cartucho = new PilaLimitada(5);
        cartucho.apilar("Batería Ion-1");
        cartucho.apilar("Batería Ion-2");
        cartucho.apilar("Batería Ion-3");
        cartucho.apilar("Batería Ion-4");
        cartucho.apilar("Batería Ion-5");
        cartucho.apilar("Batería Extra-6"); // Dispara la alerta de explosión

        // --- NIVEL 1: Desafío 2 (Star-Lord - Walkman / Cola Cíclica) ---
        System.out.println("\n--- NIVEL 1: Desafío 2 (Cola Cíclica) ---");
        Cola playlist = new Cola();
        playlist.enfilar("Come and Get Your Love");
        playlist.enfilar("Hooked on a Feeling");
        reproducirSiguiente(playlist);
        reproducirSiguiente(playlist);
        reproducirSiguiente(playlist); // Vuelve a empezar en bucle

        // --- NIVEL 2: Desafío 3 (Groot - Invertir Cola) ---
        System.out.println("\n--- NIVEL 2: Desafío 3 (Invertir Cola) ---");
        Cola coordenadas = new Cola();
        coordenadas.enfilar("X: 104.5");
        coordenadas.enfilar("Y: 89.2");
        coordenadas.enfilar("Z: -12.4");
        invertirCola(coordenadas);

        // --- NIVEL 2: Desafío 4 (Drax - Búsqueda Segura) ---
        System.out.println("\n--- NIVEL 2: Desafío 4 (Búsqueda Segura) ---");
        Pila armas = new Pila();
        armas.apilar("Blaster Pesado");
        armas.apilar("Cuchillo Lasser");
        armas.apilar("Dagas de Vibranium");
        buscarYExtraer(armas, "Dagas de Vibranium");

        // --- NIVEL 3: Desafío 5 (Nebula - Cola con 2 Pilas) ---
        System.out.println("\n--- NIVEL 3: Desafío 5 (Cola con 2 Pilas) ---");
        ColaNebula cerebroNebula = new ColaNebula();
        cerebroNebula.enfilar("Datos Alfa");
        cerebroNebula.enfilar("Datos Beta");
        cerebroNebula.sacar();

        // --- NIVEL 3: Desafío 6 (Coleccionista - Ordenar Pila) ---
        System.out.println("\n--- NIVEL 3: Desafío 6 (Ordenar Pila) ---");
        Pila gemas = new Pila();
        gemas.apilar(15);
        gemas.apilar(42);
        gemas.apilar(7);
        gemas.apilar(99);
        ordenarPila(gemas);
        System.out.println("Cima de la pila ordenada (Mayor poder): " + gemas.verCima());

        // --- NIVEL 3: Desafío 7 (Deflectores - Round-Robin) ---
        System.out.println("\n--- NIVEL 3: Desafío 7 (Simulador Round-Robin) ---");
        Cola colaSectores = new Cola();
        colaSectores.enfilar(new Sector("Frontal", 25));
        colaSectores.enfilar(new Sector("Trasero", 10));
        simularDeflectores(colaSectores);

        System.out.println("\n==================================================");
        System.out.println("🎉 ¡TODOS LOS RETOS PROBADOS CON ÉXITO EN INTELLIJ! 🎉");
        System.out.println("==================================================");
    }

    // --- MÉTODOS LÓGICOS PARA LOS DESAFÍOS 2, 3, 4, 6 y 7 ---

    public static void reproducirSiguiente(Cola playlist) {
        if (playlist.estaVacia()) return;
        Object cancion = playlist.sacar();
        System.out.println("Reproduciendo: " + cancion);
        playlist.enfilar(cancion);
    }

    public static void invertirCola(Cola cola) {
        Pila temp = new Pila();
        while (!cola.estaVacia()) {
            temp.apilar(cola.sacar());
        }
        while (!temp.estaVacia()) {
            cola.enfilar(temp.sacar());
        }
        System.out.println("¡Coordenadas de Groot invertidas exitosamente!");
    }

    public static Object buscarYExtraer(Pila armas, String objetivo) {
        Pila auxiliar = new Pila();
        Object armaEncontrada = null;

        while (!armas.estaVacia()) {
            Object arma = armas.sacar();
            if (arma.equals(objetivo)) {
                armaEncontrada = arma;
                break;
            } else {
                auxiliar.apilar(arma);
            }
        }
        while (!auxiliar.estaVacia()) {
            armas.apilar(auxiliar.sacar());
        }
        if (armaEncontrada != null) {
            System.out.println("¡Arma '" + objetivo + "' extraída sin romper el orden!");
        }
        return armaEncontrada;
    }

    public static void ordenarPila(Pila gemas) {
        Pila auxiliar = new Pila();
        while (!gemas.estaVacia()) {
            int temp = (int) gemas.sacar();
            while (!auxiliar.estaVacia() && (int) auxiliar.verCima() > temp) {
                gemas.apilar(auxiliar.sacar());
            }
            auxiliar.apilar(temp);
        }
        while (!auxiliar.estaVacia()) {
            gemas.apilar(auxiliar.sacar());
        }
        System.out.println("¡Bóveda ordenada con éxito! Gema mayor en la cima.");
    }

    public static void simularDeflectores(Cola colaSectores) {
        System.out.println("--- INICIANDO SIMULADOR ROUND-ROBIN ---");
        while (!colaSectores.estaVacia()) {
            Sector sector = (Sector) colaSectores.sacar();
            int atencion = Math.min(10, sector.energiaFaltante);
            sector.energiaFaltante -= atencion;

            System.out.println("Cargando sector " + sector.nombre + "... Faltan " + sector.energiaFaltante + " para el 100%.");

            if (sector.energiaFaltante > 0) {
                colaSectores.enfilar(sector);
            } else {
                System.out.println("¡Sector " + sector.nombre + " al 100%!");
            }
        }
        System.out.println("--- ¡TODOS LOS ESCUDOS AL 100%! ---");
    }
}