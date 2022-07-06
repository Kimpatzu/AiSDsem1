import java.io.Serializable;

public abstract class Pracownik implements Serializable {
    private String nazwisko;
    private String imie;
    private long pesel;
    private String stanowisko;
    private int staż;

    public Pracownik(String nazwisko, String imie, long pesel, String stanowisko, int staż) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.pesel = pesel;
        this.stanowisko = stanowisko;
        this.staż = staż;
    }

    public Pracownik(){
        this.nazwisko = null;
        this.imie = null;
        this.pesel = 0;
        this.stanowisko = null;
        this.staż = 0;
    }

    public void wyswietl(){
        System.out.printf("%3s", "|");
        System.out.printf("%-15s", nazwisko);
        System.out.printf("%3s", "|");
        System.out.printf("%-15s", imie);
        System.out.printf("%3s", "|");
        System.out.printf("%012d", pesel);
        System.out.printf("%3s", "|");
        System.out.printf("%-15s", stanowisko);
        System.out.printf("%3s", "|");
        System.out.printf("%-4d", staż);
        System.out.printf("%3s", "|");
        System.out.printf("%-11.2f", Pensja());
        System.out.printf("%3s", "|");
    }
    public String toString(){
        return String.format("  |%-15s  |%-15s  |%012d  |%-15s  |%-4d  |%-11.2f  |", nazwisko, imie, pesel, stanowisko, staż , Pensja());//"  |nazwisko         |imie             |pesel         |stanowisko       |staz  |pensja       |";
    }

    public abstract double Pensja();
}
