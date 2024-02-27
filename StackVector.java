import java.util.Vector;

public class StackVector<T> extends AbstractStack<T> {
    
    /**
     * Vector que representa la pila.
     */
    protected Vector<T> stackVector;
    
    /**
     * Constructor que inicializa la pila como un Vector vacío.
     */
    public StackVector() {
        stackVector = new Vector<>();
    }

    /**
     * {@inheritDoc}
     * Agrega un elemento a la parte superior de la pila.
     *
     * @param value Valor a agregar a la pila.
     */
    @Override
    public void push(T value) {
        stackVector.add(value);
    }

    /**
     * {@inheritDoc}
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return Elemento en la parte superior de la pila, o null si la pila está vacía.
     */
    @Override
    public T pop() {
        if (!isEmpty()) {
            return stackVector.remove(stackVector.size() - 1);
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return stackVector.isEmpty();
    }

    /**
     * {@inheritDoc}
     * Obtiene el número de elementos en la pila.
     *
     * @return Número de elementos en la pila.
     */
    @Override
    int size() {
        return stackVector.size();
    }
}
