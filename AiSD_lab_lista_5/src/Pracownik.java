import java.io.Serializable;

public class Pracownik implements Serializable {
    private long pesel;
    private String nazwisko;
    private String imie;
    private String data_urodzenia;
    private String stanowisko;
    private int pensja;
    private int staż;
    private int premia;

    public Pracownik(long pesel, String nazwisko, String imie, String data_urodzenia, String stanowisko, int pensja, int staż) {
        this.pesel = pesel;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.data_urodzenia = data_urodzenia;
        this.stanowisko = stanowisko;
        this.pensja = pensja;
        this.staż = staż;
        if(staż>=20){
            this.premia = pensja/5;
        } else if(staż>=10){
            this.premia = pensja/10;
        } else {
            this.premia = 0;
        }
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
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

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
        if(staż>=20){
            this.premia = pensja/5;
        } else if(staż>=10){
            this.premia = pensja/10;
        } else {
            this.premia = 0;
        }
    }

    public int getStaż() {
        return staż;
    }

    public void setStaż(int staż) {
        this.staż = staż;
        if(staż>=20){
            this.premia = pensja/5;
        } else if(staż>=10){
            this.premia = pensja/10;
        } else {
            this.premia = 0;
        }
    }

    public int getPremia() {
        return premia;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "pesel=" + pesel +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", data_urodzenia='" + data_urodzenia + '\'' +
                ", stanowisko='" + stanowisko + '\'' +
                ", pensja=" + pensja +
                ", staż=" + staż +
                ", premia=" + premia +
                '}';
    }
}
