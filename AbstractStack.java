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

    /**
     * Comprueba si la estructura de datos está vacía.
     *
     * @return true si la estructura de datos está vacía, false en caso contrario.
     */
    public abstract boolean isEmpty();

    /**
     * Obtiene el tamaño actual de la estructura de datos.
     *
     * @return El número de elementos almacenados en la estructura de datos.
     */
    abstract int size();
}