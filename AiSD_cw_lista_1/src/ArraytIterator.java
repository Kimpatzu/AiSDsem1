import java.util.NoSuchElementException;

public class ArraytIterator<T> implements java.util.Iterator {
    private T array[];
    private  int pos=0;

    public ArraytIterator(T array[]){
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return pos < array.length;
    }

    @Override
    public T next() throws NoSuchElementException {
        if (hasNext()){
            return array[pos++];
        } else {
            throw new NoSuchElementException();
        }
    }

}
