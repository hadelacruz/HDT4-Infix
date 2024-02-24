import java.util.ArrayList;

public class StackArrayList <T> extends AbstractStack<T>{

    public ArrayList<T> stackArrayList;
    int tope;

    public StackArrayList() {
        this.stackArrayList = new ArrayList<>();
        tope=-1;
    }

    @Override
    public void push(T value) {
        stackArrayList.add(value);
        tope ++;
    }

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

    @Override
    public boolean isEmpty() {
        return stackArrayList.isEmpty();
    }

    @Override
    int size() {
        return stackArrayList.size();
    }
}