import java.util.ArrayList;

public class StackArrayList <T> extends AbstractStack<T>{
    /**
     * ArrayList que representa la pila.
     */
    public ArrayList<T> stackArrayList;

    /**
     * Tope de la pila, indicando la posición del elemento superior.
     */
    int tope;

    /**
     * Constructor que inicializa la pila como un ArrayList vacío y el tope en -1.
     */
    public StackArrayList() {
        this.stackArrayList = new ArrayList<>();
        tope=-1;
    }

    /**
     * Agrega un elemento a la parte superior de la pila.
     *
     * @param value Valor a agregar a la pila.
     */
    @Override
    public void push(T value) {
        stackArrayList.add(value);
        tope ++;
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return Elemento en la parte superior de la pila, o null si la pila está vacía.
     */
    @Override
    public T pop() {
        T value;
        if(isEmpty()){
            return null;
        }
        else{
            value = stackArrayList.get(tope);
            stackArrayList.remove(tope);
            tope --;
            return value;
        }
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return stackArrayList.isEmpty();
    }

    /**
     * Obtiene el número de elementos en la pila.
     *
     * @return Número de elementos en la pila.
     */
    @Override
    int size() {
        return stackArrayList.size();
    }
}