import java.util.Vector;

public class StackVector<T> extends AbstractStack<T> {
    
    protected Vector<T> stackVector;
    
    public StackVector() {
        stackVector = new Vector<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(T value) {
        stackVector.add(value);
    }

    /**
     * {@inheritDoc}
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
     */
    @Override
    public boolean isEmpty() {
        return stackVector.isEmpty();
    }
}
