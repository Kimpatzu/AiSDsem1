public class Karta {
    private int Wartosc;
    private int Kolor;
    private String[] wartosc_tab = {"as", "2", "3","4","5","6","7","8","9","10","walet","dama","król"};
    private String[] kolor_tab = {"kier","karo","trefl","pik"};

    public Karta(int wartosc, int kolor) {
        Wartosc = wartosc;
        Kolor = kolor;
    }
    public Karta() {
        Wartosc = 0;
        Kolor = 0;
    }

    public int getWartosc() {
        return Wartosc;
    }

    public void setWartosc(int wartosc) {
        Wartosc = wartosc;
    }

    public int getKolor() {
        return Kolor;
    }

    public void setKolor(int kolor) {
        Kolor = kolor;
    }

    @Override
    public String toString() {
        String output = "";
        output += wartosc_tab[Wartosc-1] + "   ";
        output += kolor_tab[Kolor];
        return output;
    }
}
