public class PilaLimitada extends Pila {
    private int capacidadMaxima;
    private int cantidadActual;

    public PilaLimitada(int capacidadMaxima) {
        super();
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadActual = 0;
    }

    @Override
    public void apilar(Object data) {
        if (cantidadActual >= capacidadMaxima) {
            System.out.println("¡ALERTA! Capacidad máxima alcanzada (" + capacidadMaxima + "). ¡El cañón de plasma de Rocket explotará!");
            return;
        }
        super.apilar(data);
        cantidadActual++;
        System.out.println("Batería '" + data + "' acoplada. Total en cartucho: " + cantidadActual);
    }

    @Override
    public Object sacar() {
        Object data = super.sacar();
        if (data != null) {
            cantidadActual--;
            System.out.println("Batería '" + data + "' utilizada. Restantes: " + cantidadActual);
        }
        return data;
    }
}