public abstract class AbstractStack<T> {
    /**
     * Agrega un valor a la pila.
     * 
     * @param value el valor que se agregará a la pila.
     */
    abstract public void push(T value);

    /**
     * Extrae un valor de la pila.
     * 
     * @return el valor extraído de la pila.
     */
    abstract public T pop();
}
