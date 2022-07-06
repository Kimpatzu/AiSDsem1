public class Karta implements Comparable<Karta>{
    private int wartosc;
    private int kolor;
    private boolean znacznik;

    public Karta(int wartosc, int kolor) {
        this.wartosc = wartosc;
        if (wartosc==14){
            this.znacznik=false;
            this.kolor=5;
        } else {
            this.znacznik=true;
            this.kolor = kolor;
        }
    }

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public int getKolor() {
        return kolor;
    }

    public void setKolor(int kolor) {
        this.kolor = kolor;
    }

    public boolean isZnacznik() {
        return znacznik;
    }

    public void setZnacznik(boolean znacznik) {
        this.znacznik = znacznik;
    }

    public String toString(){
        if(!znacznik){
            return "()";
        }
        else {
            String[] wartosc_tab = {"as", "2", "3","4","5","6","7","8","9","10","walet","dama","król"};
            String[] kolor_tab = {"kier","karo","trefl","pik"};
            return wartosc_tab[wartosc-1] + "   " + kolor_tab[kolor];
        }
    }

    @Override
    public int compareTo(Karta karta) {
        if (isZnacznik() && !karta.isZnacznik()){
            return  1;
        }
        if (!isZnacznik() && !karta.isZnacznik()){
            return 0;
        }
        if (isZnacznik() && karta.isZnacznik()){
            if (this.getWartosc()<karta.getWartosc()){
                return -1;
            }
            if (this.getWartosc()>karta.getWartosc()){
              return 1;
            }
            if (this.getWartosc()==karta.getWartosc()){
                if (this.getKolor()< karta.getKolor()){
                   return 1;
                 }
                if (this.getKolor()> karta.getKolor()){
                    return -1;
                }
                if (this.getKolor()== karta.getKolor()){
                    return -1;
                }
            }
        }
        return -1;
    }
}
