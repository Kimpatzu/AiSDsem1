public class Magazyn {
    private OneWayLinkedListWithHeadAndTailQueue<Klient> kolejkaKlientow;
    private OneWayLinkedListWithHeadAndTailQueue<ZlecenieZrealizowane> wykazDochodow;
    private float allProfits;
    private boolean dayEnded;

    public Magazyn(OneWayLinkedListWithHeadAndTailQueue<Klient> kolejkaKlientow, OneWayLinkedListWithHeadAndTailQueue<ZlecenieZrealizowane> wykazDochodow) {
        this.kolejkaKlientow = kolejkaKlientow;
        this.wykazDochodow = wykazDochodow;
        this.allProfits = 0;
    }

    public Magazyn(OneWayLinkedListWithHeadAndTailQueue<Klient> kolejkaKlientow){
        this.kolejkaKlientow = kolejkaKlientow;
        this.wykazDochodow = new OneWayLinkedListWithHeadAndTailQueue<>();
        this.allProfits = 0;
    }

    public Magazyn(){
        this.kolejkaKlientow  = new OneWayLinkedListWithHeadAndTailQueue<>();
        this.wykazDochodow = new OneWayLinkedListWithHeadAndTailQueue<>();
        this.allProfits = 0;
        this.dayEnded = false;
    }

    public void enqueue(Klient k){
        kolejkaKlientow.enqueue(k);
    }

    public String executeOrder(){
        if (dayEnded){
            return null;
        }
        if (!kolejkaKlientow.isEmpty()){
            Klient k = kolejkaKlientow.dequeue();
            OneWayLinkedListWithHeadAndTailQueue<Zamowienie>  zamowienia= k.getZamowienia();
            float sumaKwot = 0;
            float actCenaJednostkowa = 0;
            int actLiczbaSztuk = 0;
            Zamowienie actZamowienie;
            String controlOutput = "";
            while(!zamowienia.isEmpty()){
                actZamowienie = zamowienia.dequeue();
                actCenaJednostkowa = actZamowienie.getCenaJednostkowa();
                actLiczbaSztuk  = actZamowienie.getLiczbaSztuk();
                controlOutput += actCenaJednostkowa + "  " + actLiczbaSztuk + "\n";
                sumaKwot += actCenaJednostkowa*actLiczbaSztuk;
            }
            allProfits += sumaKwot;
            wykazDochodow.enqueue(new ZlecenieZrealizowane(k.getNazwaKlienta(),sumaKwot));
            return "Zlecenie zrealizowane: " + k.getNazwaKlienta() + " Kwota do zaplaty: " + sumaKwot + "\n" + controlOutput;
        } else if (!wykazDochodow.isEmpty()){
            dayEnded = true;
            return "Koniec zleceń.\nLiczba zleceń: " + wykazDochodow.size() + " łączny dochód: " + allProfits;
        } else return null;
    }

    public OneWayLinkedListWithHeadAndTailQueue<Klient> getKolejkaKlientow() {
        return kolejkaKlientow;
    }


    public void setKolejkaKlientow(OneWayLinkedListWithHeadAndTailQueue<Klient> kolejkaKlientow) {
        this.kolejkaKlientow = kolejkaKlientow;
    }

    public OneWayLinkedListWithHeadAndTailQueue<ZlecenieZrealizowane> getWykazDochodow() {
        return wykazDochodow;
    }

    public void setWykazDochodow(OneWayLinkedListWithHeadAndTailQueue<ZlecenieZrealizowane> wykazDochodow) {
        this.wykazDochodow = wykazDochodow;
    }

    public String rozliczMagazyn(){
        String output = "";
        OneWayLinkedListWithHeadAndTailQueue<ZlecenieZrealizowane> rozliczenie = wykazDochodow;
        ZlecenieZrealizowane actZlecenie;
        while(!rozliczenie.isEmpty()){
            actZlecenie = rozliczenie.dequeue();
            output += actZlecenie + "\n";
        }
        return output;
    }

    public float getAllProfits() {
        return allProfits;
    }

    public void setAllProfits(float allProfits) {
        this.allProfits = allProfits;
    }
}
