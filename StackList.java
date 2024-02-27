public class StackList<T> extends AbstractStack<T>{
    /**
     * Último nodo de la pila.
     */
    protected Node<T> lastNode;
    /**
     * Primer nodo de la pila.
     */
    protected Node<T> firstNode;

    /**
     * {@inheritDoc}
     * Agrega un elemento a la parte superior de la pila.
     *
     * @param value Valor a agregar a la pila.
     */
    @Override
    public void push(T value) {
        if (lastNode == null) {
            lastNode = new Node<T>(value);
            firstNode = lastNode;
        } else {
            Node<T> current = new Node<T>(value);
            current.setNext(firstNode);
            firstNode = current;
        }
    }

    /**
     * {@inheritDoc}
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return Elemento en la parte superior de la pila, o null si la pila está vacía.
     */
    @Override
    public T pop() {
        if (lastNode != null) {
            if (firstNode.equals(lastNode)) {
                T valueT = lastNode.getValue();
                firstNode = null;
                lastNode = null;
                return valueT;
            } else {
                T valueFirst = firstNode.getValue();
                firstNode = firstNode.getNext();
                return valueFirst;
            }
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     * Obtiene el tamaño actual de la pila.
     *
     * @return El tamaño de la pila.
     */
    public int size() {
        int count = 0;
        Node<T> current = firstNode;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    /**
     * {@inheritDoc}
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }   
}