public class Cola {
    protected Node head;
    protected Node tail;
    protected int size;

    public Cola() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean estaVacia() {
        return head == null;
    }

    public void enfilar(Object data) {
        Node nuevo = new Node(data);
        if (estaVacia()) {
            head = nuevo;
            tail = nuevo;
        } else {
            tail.next = nuevo;
            tail = nuevo;
        }
        size++;
    }

    public Object sacar() {
        if (estaVacia()) return null;
        Object data = head.data;
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
        return data;
    }
}