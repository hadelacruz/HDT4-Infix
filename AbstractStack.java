public abstract class AbstractStack<T> {

    /**
     * Agrega un valor a la pila.
     * 
     * @param resultado el valor que se agregará a la pila.
     */
    abstract public void push(T resultado);

    /**
     * Extrae un valor de la pila.
     * 
     * @return el valor extraído de la pila.
     */
    abstract public T pop();

    public abstract boolean isEmpty();

    abstract int size();
}