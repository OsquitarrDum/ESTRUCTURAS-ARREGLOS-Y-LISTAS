public class Pila {
    protected Node top;
    protected int size;

    public Pila() {
        this.top = null;
        this.size = 0;
    }

    public boolean estaVacia() {
        return top == null;
    }

    public void apilar(Object data) {
        Node nuevo = new Node(data);
        nuevo.next = top;
        top = nuevo;
        size++;
    }

    public Object sacar() {
        if (estaVacia()) return null;
        Object data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public Object verCima() {
        if (estaVacia()) return null;
        return top.data;
    }
}