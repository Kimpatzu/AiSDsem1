public class PracownikEtatowy extends Pracownik {
    private float etat;
    private double stawka;

    public PracownikEtatowy(String nazwisko, String imie, long pesel, String stanowisko, int staż, float etat, double stawka) {
        super(nazwisko, imie, pesel, stanowisko, staż);
        this.etat = etat;
        this.stawka = stawka;
    }

    public PracownikEtatowy() {
        super();
        this.etat = 0;
        this.stawka = 0;
    }

    @Override
    public double Pensja() {
        return stawka*etat;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
