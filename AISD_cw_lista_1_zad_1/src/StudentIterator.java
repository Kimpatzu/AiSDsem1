import java.util.Iterator;
import java.util.NoSuchElementException;

public class StudentIterator implements Iterator {

    private Student tab[];
    private int pos = 0;

    public StudentIterator(Student tab[]){
        this.tab = tab;
    }

    @Override
    public boolean hasNext() {
        return pos < tab.length;
    }

    @Override
    public Student next() throws NoSuchElementException {
        if (hasNext()){
            return  tab[pos++];
        }
        else{
            throw new NoSuchElementException();
        }
    }

    public String wyswietlTabele(){
        return this.toString();
    }

    public String wyswietlStudenta(){
        return tab[pos].toString();
    }

    public String wyswietlListaNieZaliczeni(){
        String output = "";
        for (int i=0; i< tab.length; i++){
            if (tab[i].getOcena()<3){
                output+=tab[i] + "\n";
            }
        }
        return output;
    }

    public String toString(){
        String output = "";
        for (int i=0; i< tab.length; i++){
            output+=tab[i] + "\n";
        }
        return output;
    }

    public void wpiszOcene(String nrIndeksu , float ocena){
        for (int i=0; i< tab.length; i++){
            if (tab[i].getNrIndeksu().equals(nrIndeksu)){
                tab[i].setOcena(ocena);
                i=tab.length;
            }
        }
    }

    public float getSredniaPozytywnychOcen(){
        float suma = 0;
        int liczbaOcen = 0;
        for (int i=0; i<tab.length; i++){
            if (tab[i].getOcena()>=3){
                suma+=tab[i].getOcena();
                liczbaOcen++;
            }
        }
        return suma/liczbaOcen;
    }
}
