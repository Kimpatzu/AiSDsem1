import java.util.ArrayList;

public class Student {
    private int nrIndeksu;
    private String nazwisko;
    private String imie;
    private ArrayList<Float> oceny;

    public Student(int nrIndeksu, String nazwisko, String imie, ArrayList<Float> oceny) {
        this.nrIndeksu = nrIndeksu;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.oceny = oceny;
    }

    public int getNrIndeksu() {
        return nrIndeksu;
    }

    public void setNrIndeksu(int nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public ArrayList<Float> getOceny() {
        return oceny;
    }

    public float getOCena(int i){
        return oceny.get(i);
    }

    public void setOceny(ArrayList<Float> oceny) {
        this.oceny = oceny;
    }

    public void addOcena(float ocena){
        this.oceny.add(ocena);
    }
    public float getSredniaOcen(){
        float suma = 0;
        float licznik =0;
        for (int i=0; i<oceny.size(); i++){
            suma+=oceny.get(i);
            licznik++;
        }
        return suma/licznik;
    }

    public String toString(){
        String output = "";
        output+=nrIndeksu + "   " + nazwisko + "    " + imie + "    | ";
        for (int i=0; i< oceny.size(); i++){
            output+=oceny.get(i) + " | ";
        }
        return output;
    }
}
