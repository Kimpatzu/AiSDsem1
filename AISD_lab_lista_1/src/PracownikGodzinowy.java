public class PracownikGodzinowy extends Pracownik{
    private double stawka;
    private int liczba_godzin;

    public PracownikGodzinowy(String nazwisko, String imie, long pesel, String stanowisko, int staż, double stawka, int liczba_godzin) {
        super(nazwisko, imie, pesel, stanowisko, staż);
        this.stawka = stawka;
        this.liczba_godzin = liczba_godzin;
    }

    public PracownikGodzinowy() {
        super();
        this.stawka = 0;
        this.liczba_godzin = 0;
    }

    @Override
    public double Pensja() {
        return stawka*liczba_godzin;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
