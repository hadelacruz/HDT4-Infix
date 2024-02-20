public class StackList<T> extends AbstractStack<T>{

    protected Node<T> lastNode;
    protected Node<T> firstNode;

    /**
     * {@inheritDoc}
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

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
    
}
