public class Zamowienie {
    private String nazwaTowaru;
    private int liczbaSztuk;
    private float cenaJednostkowa;

    public Zamowienie(String nazwaTowaru, int liczbaSztuk, float cenaJednostkowa) {
        this.nazwaTowaru = nazwaTowaru;
        this.liczbaSztuk = liczbaSztuk;
        this.cenaJednostkowa = cenaJednostkowa;
    }

    public String getNazwaTowaru() {
        return nazwaTowaru;
    }

    public void setNazwaTowaru(String nazwaTowaru) {
        this.nazwaTowaru = nazwaTowaru;
    }

    public int getLiczbaSztuk() {
        return liczbaSztuk;
    }

    public void setLiczbaSztuk(int liczbaSztuk) {
        this.liczbaSztuk = liczbaSztuk;
    }

    public float getCenaJednostkowa() {
        return cenaJednostkowa;
    }

    public void setCenaJednostkowa(float cenaJednostkowa) {
        this.cenaJednostkowa = cenaJednostkowa;
    }
}
