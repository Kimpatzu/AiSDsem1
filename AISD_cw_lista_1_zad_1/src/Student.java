public class Student {
    private String nrIndeksu;
    private String nazwisko;
    private String imie;
    private float ocena;

    public Student(String nrIndeksu, String nazwisko, String imie, float ocena) {
        this.nrIndeksu = nrIndeksu;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.ocena = ocena;
    }

    public String getNrIndeksu() {
        return nrIndeksu;
    }

    public void setNrIndeksu(String nrIndeksu) {
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

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public String toString(){
        String output = "";
        output+=nrIndeksu + "   " + nazwisko + "    " + imie + "    " + ocena;
        return output;
    }
}
