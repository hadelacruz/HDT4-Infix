/**
 * Clase de nodo para una lista enlazada.
 * 
 * @param <T> el tipo de elemento en el nodo.
 */
public class Node<T> {
    T value;
    Node<T> next;
    Node<T> previous;

    /**
     * Constructor que inicializa un nodo con un valor dado.
     * 
     * @param value el valor del nodo.
     */
    public Node(T value){
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    /**
     * Obtiene el valor almacenado en el nodo.
     * 
     * @return el valor del nodo.
     */
    public T getValue() {
        return this.value;
    }
 
    /**
     * Obtiene el siguiente nodo en la lista enlazada.
     * 
     * @return el siguiente nodo.
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Establece un nuevo valor para el nodo.
     * 
     * @param newValue el nuevo valor a establecer.
     */
    public void setValue(T newValue) {
        this.value = newValue;
    }

    /**
     * Establece el siguiente nodo en la lista enlazada.
     * 
     * @param next el siguiente nodo.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}