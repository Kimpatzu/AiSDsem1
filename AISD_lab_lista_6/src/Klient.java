public class Klient {
    private OneWayLinkedListWithHeadAndTailQueue<Zamowienie> zamowienia;
    private String nazwaKlienta;

    public Klient(OneWayLinkedListWithHeadAndTailQueue<Zamowienie> zamowienia, String nazwaKlienta) {
        this.zamowienia = zamowienia;
        this.nazwaKlienta = nazwaKlienta;
    }

    public OneWayLinkedListWithHeadAndTailQueue<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(OneWayLinkedListWithHeadAndTailQueue<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }

    public String getNazwaKlienta() {
        return nazwaKlienta;
    }

    public void setNazwaKlienta(String nazwaKlienta) {
        this.nazwaKlienta = nazwaKlienta;
    }
}
