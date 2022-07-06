import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorKart<T> implements Iterator<T> {
    private ArrayList<T> lista;
    private int pos=0;

    public IteratorKart(ArrayList<T> lista) {
        this.lista = lista;
    }

    @Override
    public boolean hasNext() {
        return pos<lista.size();
    }

    @Override
    public T next() throws NoSuchElementException {
        if (hasNext()){
            return lista.get(pos++);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void wyswietl(){
        while(hasNext()){
            System.out.println(next());
        }
    }
}
