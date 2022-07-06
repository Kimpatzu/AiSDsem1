import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorPracownikow implements Iterator {
    private Pracownik[] pracowniks;
    private int pos = 0;

    public IteratorPracownikow(Pracownik[] pracowniks) {
        this.pracowniks = pracowniks;
    }

    @Override
    public boolean hasNext() {
        return pos< pracowniks.length;
    }

    @Override
    public Pracownik next() throws NoSuchElementException {
        if (hasNext()){
            return pracowniks[pos++];
        } else{
            throw new NoSuchElementException();
        }
    }

    public void wyswietl(){
        System.out.println("  |nazwisko         |imie             |pesel         |stanowisko       |staz  |pensja       |");
        while(hasNext()){
            next().wyswietl();
            System.out.print("\n");
        }
    }
}
