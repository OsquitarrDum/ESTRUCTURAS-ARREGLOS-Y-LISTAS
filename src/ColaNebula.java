public class ColaNebula {
    private Pila pilaEntrada;
    private Pila pilaSalida;

    public ColaNebula() {
        pilaEntrada = new Pila();
        pilaSalida = new Pila();
    }

    public void enfilar(Object data) {
        pilaEntrada.apilar(data);
        System.out.println("[Nebula] Dato enfilado: " + data);
    }

    public Object sacar() {
        if (pilaSalida.estaVacia()) {
            while (!pilaEntrada.estaVacia()) {
                pilaSalida.apilar(pilaEntrada.sacar());
            }
        }
        if (pilaSalida.estaVacia()) {
            System.out.println("[Nebula] El procesador está vacío.");
            return null;
        }
        Object data = pilaSalida.sacar();
        System.out.println("[Nebula] Dato extraído en orden FIFO: " + data);
        return data;
    }

    public boolean estaVacia() {
        return pilaEntrada.estaVacia() && pilaSalida.estaVacia();
    }
}