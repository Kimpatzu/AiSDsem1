public class ZlecenieZrealizowane {
    private String nazwaKlienta;
    private float kwotaWszystkichZamowien;

    public ZlecenieZrealizowane(String nazwaKlienta, float kwotaWszystkichZamowien) {
        this.nazwaKlienta = nazwaKlienta;
        this.kwotaWszystkichZamowien = kwotaWszystkichZamowien;
    }

    public String getNazwaKlienta() {
        return nazwaKlienta;
    }

    public void setNazwaKlienta(String nazwaKlienta) {
        this.nazwaKlienta = nazwaKlienta;
    }

    public float getKwotaWszystkichZamowien() {
        return kwotaWszystkichZamowien;
    }

    public void setKwotaWszystkichZamowien(float kwotaWszystkichZamowien) {
        this.kwotaWszystkichZamowien = kwotaWszystkichZamowien;
    }

    public String toString(){
        return nazwaKlienta + " " + kwotaWszystkichZamowien;
    }
}
